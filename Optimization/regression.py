import numpy
import torch
import pandas as pd
from decomposition import qr_decomposition
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split

from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error


def linear_regression(X, y):
    """

    :return:
    """
    W = torch.zeros(size=(X.shape[1], ))

    # QR decomposition
    # Q, R = qr_decomposition(X)  # Wow this is slow...
    Q, R = torch.linalg.qr(X)
    W = torch.inverse(R.T @ R) @ R.T @ Q.T @ y

    # Moors Penrose pseudo-inverse is a special case of Tikhonov regularization where lambda is infinitesimally small
    if X.shape[0] < X.shape[1] * 5:
        W = torch.linalg.pinv(X)[:, 0]

    return W


def linear_regression_gd(X, y, step=100, alpha=0.01, regularization=0.0001):
    """
    Linear regression with gradient descent

    :param X:
    :param y:
    :return:
    """
    W = torch.randn(size=(1, X.shape[1]))
    bias = torch.zeros(size=(1, X.shape[1]))

    for step in range(step):
        error = X @ W.T - y  # Calculate the error, resulting in shape [n, 1]
        gradient = X.T @ error / X.shape[0]
        gradient = gradient.T

        # Gradient update
        W -= alpha * gradient
        # bias -= alpha * gradient.T

        # Regularization (L1)
        # W -= 1 - alpha * regularization  # This is wrong.
        W -= alpha * regularization * torch.sign(W)
        # bias -= alpha * regularization * torch.sign(W)

    return W.T, bias.T


if __name__ == '__main__':
    dataset_name = 'apple_quality.csv'
    df = pd.read_csv(dataset_name)
    print(df[['Size', 'Weight', 'Sweetness', 'Crunchiness', 'Juiciness', 'Ripeness', 'Quality']].dtypes)

    print(df.keys())

    # Estimate price based on neighborhood group and review per month
    # Neighborhood group need to be encoded
    data = df.filter(items=['Size', 'Weight', 'Sweetness', 'Crunchiness', 'Juiciness', 'Ripeness', 'Quality'])

    # Filter NaN
    data = data.dropna()

    # Encode neighborhood name
    # Initialize the LabelEncoder
    le = LabelEncoder()

    # Fit and transform the 'neighbourhood_group' column
    data['Quality'] = le.fit_transform(data['Quality'])

    X = torch.Tensor(data.filter(['Size', 'Weight', 'Sweetness', 'Crunchiness', 'Juiciness',
                                  'Ripeness']).to_numpy())
    y = torch.Tensor(data.filter(['Quality']).to_numpy())

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)

    # Linear regression
    W = linear_regression(X_train, y_train)
    y_hat_mine = X_test @ W

    regression = LinearRegression()
    regression.fit(X_train, y_train)
    y_hat = regression.predict(X_test)

    y_hat = numpy.round(torch.tensor(y_hat))
    y_hat_mine = numpy.round(y_hat_mine)
    print(y_test[:10].T)
    print(y_hat[:10].T)
    print(y_hat_mine[:10].T)

    # Gradient based method
    W, bias = linear_regression_gd(X_train, y_train, step=50000, alpha=0.0001, regularization=0.00001)
    y_hat_mine_gd = X_test @ W
    print(numpy.round(y_hat_mine_gd[:10].T))

    print(f"My loss: {mean_squared_error(y_test, y_hat_mine)}, Public impl loss: {mean_squared_error(y_test, y_hat)}, "
          f"My Gradient Descent loss: {mean_squared_error(y_test, y_hat_mine_gd)}")
