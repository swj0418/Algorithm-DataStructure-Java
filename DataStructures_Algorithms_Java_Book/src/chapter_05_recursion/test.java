package chapter_05_recursion;

public class test {
    public static void main(String[] ar) {
        Factorial F_10 = new Factorial(1);
        System.out.println(F_10.getAnswer());

        System.out.println("English Ruler");
        new EnglishRuler(3);

        System.out.println("Binary Search");
        int[] data = {1, 5, 6, 8, 15, 18, 19, 22, 25, 28};
        Boolean result = BinarySearch.binarySearch(data, 1, 0, data.length - 1);
        System.out.println(result);
    }
}
