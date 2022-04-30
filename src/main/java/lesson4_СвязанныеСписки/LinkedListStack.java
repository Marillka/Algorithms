package lesson4_СвязанныеСписки;

import lesson3_StackAndQueue.Stack.Stack;

public class LinkedListStack<E> implements Stack<E> {

    // Структура данных для хранения стека.
    private final LinkedList<E> data;

    // конструктор. В качестве основы придуманный нами SimpleLinkedListImpl();
    public LinkedListStack() {
        this.data = new SimpleLinkedListImpl<>();
    }

    // добавление элемента (фактически добавление в самый верх).
    @Override
    public boolean push(E value) {
        data.insertFirst(value);
        return true;
    }

    // удаление верхнего
    @Override
    public E pop() {
        return data.removeFirst();
    }

    //
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

    //всегда false. Стэк не может быть заполнен, всегда будет продолжаться
    @Override
    public boolean isFull() {
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
