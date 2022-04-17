package lesson4_СвязанныеСписки;

import lesson3_StackAndQueue.Stack.Stack;

public class LinkedListStack<E> implements Stack<E> {

    private final LinkedList<E> data;

    public LinkedListStack() {
        this.data = new SimpleLinkedListImpl<>();
    }

    @Override
    public boolean push(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {// не может быть заполнен, всегда будет продолжаться
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "data=" + data +
                '}';
    }
}
