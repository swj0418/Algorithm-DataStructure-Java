package chapter_07_list_abstractions;

public class ArrayList<E> implements List<E> {
    // Instance Variables
    public static final int CAPACITY = 16;
    private E data[];
    private int size = 0;

    // Constructors
    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {

    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
        }
    }
}
