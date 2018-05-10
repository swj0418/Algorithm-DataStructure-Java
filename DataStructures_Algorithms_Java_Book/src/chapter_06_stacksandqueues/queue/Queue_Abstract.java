package chapter_06_stacksandqueues.queue;

public interface Queue_Abstract<E> {
    /** Returns the number of elements in the queue */
    int getSize();
    /** Checks if the queue is empty */
    boolean isEmpty();
    /** Inserts an element at the rear of the queue */
    void enqueue(E e);
    /** Returns, but does not remove, the last element of the queue */
    E first();
    /** Removes and returns the first element of the queue */
    E dequeue();
}
