package chapter_06_stacksandqueues.queue;

import chapter_03_arrays_and_linked_lists.List.SinglelyLinkedList;

public class LinkedQueue<E> implements Queue_Abstract<E> {
    private SinglelyLinkedList<E> list = new SinglelyLinkedList<E>();

    public LinkedQueue() {

    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
