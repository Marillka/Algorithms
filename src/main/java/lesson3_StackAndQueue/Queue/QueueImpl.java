package lesson3_StackAndQueue.Queue;

import java.util.Arrays;

public class QueueImpl<E> implements Queue<E> {

    private final E[] data;
    private int size;
    private int tail;// индекс хвоста очереди
    private int head;// индекс головы очереди

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = -1;
        head = 0;
    }

    @Override
    public boolean insert(E value) {
        if(isFull()) {
            return false;
        }

        // организовать закольцовывание

        data[++tail] = value;// Кладем на следующию после хвоста позицию
        size++;
        return true;

    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        // организовать закольцовывание

        E value = data[head];
        data[head++] = null;
        size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
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

        for (int i = head; i <= tail ; i++) {
            sb.append(data[i]);
            if (i != tail) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

}
