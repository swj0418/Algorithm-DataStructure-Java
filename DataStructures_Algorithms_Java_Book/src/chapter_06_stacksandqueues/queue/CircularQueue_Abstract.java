package chapter_06_stacksandqueues.queue;

public interface CircularQueue_Abstract<E> extends Queue_Abstract<E> {
    /**
     * Rotates the front element of the queue to the back of the queue.
     * This does nothing if the queue is empty
     */
    void rotate();
}
