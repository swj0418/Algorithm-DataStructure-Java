package chapter_03_arrays_and_linked_lists.List;

public class test {
    public static void main(String[] ar) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(30);
        list.addLast(40);
        list.addFirst(50);
        list.addLast(60);
        for(int i = 0; i < list.getSize(); i++) {
            System.out.println(list.first());
            list.rotate();
        }
    }
}
