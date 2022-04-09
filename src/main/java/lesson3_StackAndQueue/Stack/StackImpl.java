package lesson3_StackAndQueue.Stack;

import java.util.Arrays;

public class StackImpl<E> implements Stack<E> {

    private Object[] data;
    private int size;

    public StackImpl(int maxSize) {
        this.data = new Object[maxSize];
    }

    // добавление
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        data[size++] = value;// сначала добавим элемент, а потом увеличим size на единицу.
        return true;
    }

    // извлечение с возвратом
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = peek();
        data[--size] = null;
        return value;
    }

    // возврат без присвоения
    @Override
    public E peek() {
        return (E)data[size - 1];
    }

    // размер стека
    @Override
    public int size() {
        return size;
    }

    // проверка на пустоту.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // проверка на заполненность
    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
