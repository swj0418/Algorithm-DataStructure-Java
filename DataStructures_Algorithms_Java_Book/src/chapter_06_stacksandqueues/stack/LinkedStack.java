package chapter_06_stacksandqueues.stack;

import chapter_03_arrays_and_linked_lists.List.CircularlyLinkedList;

public class LinkedStack<E> implements Stack_Abstract {
    private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();
    public LinkedStack() {

    }
    @Override
    public void push(Object obj) {
        list.addFirst((E)obj);
    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public Object top() {
        return null;
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return list.isEmpty();
    }
}
