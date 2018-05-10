package chapter_05_recursion;

public class Factorial {
    private double answer = 1.d;
    Factorial(int n) {
        performOperation(n);
    }

    public void performOperation(int n) {
        if(n == 1) {
            answer *=  n;
        } else {
            answer *= n--;
            performOperation(n);
        }
    }
    public double getAnswer() {
        return answer;
    }
}
