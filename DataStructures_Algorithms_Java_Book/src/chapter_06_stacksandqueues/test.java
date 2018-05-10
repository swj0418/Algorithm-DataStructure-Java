package chapter_06_stacksandqueues;

import chapter_06_stacksandqueues.queue.LinkedQueue;
import chapter_06_stacksandqueues.stack.Stack;

public class test {
    public static void main(String[] ar) {
        Stack S = new Stack();
        System.out.println("Empty? " + S.isEmpty());
        System.out.println("Adding three elements of different types");
        S.push(10); S.push("Hello"); S.push("This is a stack implementation/ 100");
        System.out.println("Empty? " + S.isEmpty());
        System.out.println("Size : " + S.size());
        System.out.println("Popping one");
        System.out.println(S.pop());
        System.out.println("Size : " + S.size());
        System.out.println("Looking without Popping");
        System.out.println(S.top());
        System.out.println("Size : " + S.size());

        System.out.println("=========================================================================================");
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(100);
        linkedQueue.enqueue(200);
        linkedQueue.enqueue(600);
        System.out.println(linkedQueue.getSize());
        linkedQueue.dequeue();
        linkedQueue.dequeue();
        System.out.println(linkedQueue.dequeue());
        System.out.println("Size of the linked queue : " + linkedQueue.getSize());
    }
}
