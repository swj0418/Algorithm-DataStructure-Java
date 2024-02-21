import torch


def gram_schmidt(A, normalize=True, maintain_size=True, return_R=False):
    """
    A is a (n x d) matrix where n >= d, and A = {a_1, ..., a_d}. Decompose it to Q and R where Q = {q_1, ... q_d} such
    that

    Case 1: columns in A are linearly dependent and the basis vectors are unnormalized.
    Case 2: columns in A are linearly independent.

    1. First set q_1 = a_1
    2. Adjust q_2 by removing a_1 projection on q_1 from it.
    3. projection of a_3 on both q_1 and q_2

    if A is linearly independent, this process results in all non-zero vectors in Q.

    :param A: non-orthogonal vectors {a_1, ..., a_d}
    :return:
    """

    Q = torch.zeros_like(A)
    R = torch.zeros(size=(A.shape[1], A.shape[1]))

    # Set first row vector in Q to a_0
    Q[0] = -A[0]
    i = 1
    while i != Q.shape[0]:
        # Projection
        q_i = A[i]  # To be orthogonalized
        for j in range(0, i):
            q_i = q_i - (torch.dot(q_i, Q[j]) / torch.dot(Q[j], Q[j])) * Q[j]  # No transpose needed in .dot() op.
        Q[i] = q_i

        # Increment
        i += 1

    if normalize:
        Q = Q / torch.norm(Q, dim=-1, keepdim=True)

    if maintain_size:
        Q = torch.nan_to_num(Q, 0)
    else:
        Q = Q[~torch.all(Q.isnan(), dim=1)]

    # Return Q as column vectors
    Q = torch.transpose(Q, dim0=0, dim1=1)

    if return_R:
        for i in range(Q.shape[0]):
            for j in range(i, Q.shape[1]):
                R[i, j] = A[:, j] @ Q[:, i]

    if return_R:
        return Q, R
    else:
        return Q, None


def qr_decomposition(A, normalize=True, maintain_size=True):
    """
    R: upper triangle of (d x d) matrix. (j, r)th entry is q_j @ a_r.T where j > r.

    :param A:
    :return:
    """

    # Orthonormal matrix
    Q, R = gram_schmidt(A, normalize=normalize, maintain_size=maintain_size, return_R=True)
    return Q, R


if __name__ == '__main__':
    A = torch.tensor([
        [0, 0, 0, 0, 5],
        [0, 1, 0, 0, 3],
        [0, 0, 0, 1, 0],
        [0, 0, 2, 0, 0],
        [0, 0, 0, 0, 3],
    ], dtype=torch.float)

    A = torch.tensor(
        [[1., 1., 0.],
               [1., 0., 1.],
               [0., 1., 1.]], dtype=torch.float)

    Q = gram_schmidt(A, normalize=True, maintain_size=False)

    Q, R = qr_decomposition(A, normalize=True, maintain_size=True)
    print(Q)
    print(R)
    print(Q @ R)

    Q, R = torch.linalg.qr(A)
    print(Q)
    print(R)
    print(Q@R)
