package chapter_06_stacksandqueues.stack;

public class DataNode<E> {
    private E element;
    public DataNode(E e) {
        this.element = e;
    }
    public E getElement() {
        return element;
    }
}
