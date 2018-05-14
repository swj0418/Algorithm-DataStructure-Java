package chapter_07_list_abstractions;

/** A simplified version of the java.util.List interface */
public interface List<E> {
    /** Returns the number of elements in this list */
    int size();
    /** Returns whether the list is empty */
    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;

    E set(int i, E e) throws IndexOutOfBoundsException;

    void add(int i, E e) throws IndexOutOfBoundsException;

    E remove(int i) throws IndexOutOfBoundsException;
}
