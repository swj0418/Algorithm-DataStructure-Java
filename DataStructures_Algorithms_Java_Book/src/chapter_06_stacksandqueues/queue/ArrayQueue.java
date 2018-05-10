package chapter_06_stacksandqueues.queue;

public class ArrayQueue<E> implements Queue_Abstract<E> {
    private E[] data;
    private int frontIdx = 0;
    private int currentElements = 0;

    public ArrayQueue() {

    }
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int getSize() {
        return currentElements;
    }

    @Override
    public boolean isEmpty() {
        return currentElements == 0;
    }

    @Override
    public void enqueue(E e) throws IllegalStateException{
        if(currentElements == data.length) {
            throw new IllegalStateException("Queue is Full");
        }
        int availableSpace = (frontIdx + currentElements) % data.length;
        data[availableSpace] = e;
        currentElements++;
    }

    @Override
    public E first() {
        if(isEmpty()) {
            return null;
        }
        return data[frontIdx];
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            return null;
        }
        E toDequeue = data[frontIdx];
        data[frontIdx] = null;
        frontIdx = (frontIdx + 1) % data.length;
        currentElements--;

        return toDequeue;
    }
}
