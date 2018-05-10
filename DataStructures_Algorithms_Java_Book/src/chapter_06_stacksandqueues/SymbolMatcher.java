package chapter_06_stacksandqueues;

public class SymbolMatcher {
    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        java.util.Stack<Character> buffer = new java.util.Stack<>();
        for(char c : expression.toCharArray()) {
            if(opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if(closing.indexOf(c) != -1) {
                if(buffer.isEmpty()) {
                    return false;
                } if(closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    public static void main(String[] ar) {
        System.out.println(isMatched("{ Blah Blah Blah }"));
    }
}
