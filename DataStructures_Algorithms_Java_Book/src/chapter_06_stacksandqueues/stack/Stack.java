package chapter_06_stacksandqueues.stack;

interface Stack_Abstract {
    /**
     *
     * @param obj
     */
    public void push(Object obj);

    /**
     * Returns object and removes it at the same time
     * @return obj (Top element of the stack)
     */
    public Object pop();

    /**
     * Returns top object, but does not remove it from the stack.
     * @return obj (Top element of the stack)
     */
    public Object top();
    public int size();
    public Boolean isEmpty();
}

public class Stack implements Stack_Abstract{
    private int INITIAL_CAPACITY = 1000;
    private int top = 0;

    private DataNode[] Data;

    public Stack() {
        Data = new DataNode[INITIAL_CAPACITY];
    }

    @Override
    public void push(Object obj) {
        if (top == 0) {
            Data[++top] = new DataNode(obj);
        } else {
            Data[++top] = new DataNode(obj);
        }
    }

    @Override
    public Object pop() {
        if(isEmpty()) {
            return null;
        } else {
            DataNode ret = Data[top];
            Data[top--] = null;
            return ret.getElement();
        }
    }

    @Override
    public Object top() {
        if(isEmpty()) {
            return null;
        } else {
            return Data[top].getElement();
        }
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public Boolean isEmpty() {
        if(Data[top] == null) {
            return true;
        } else {
            return false;
        }
    }

    private void upsizeCapacity() {

    }
}