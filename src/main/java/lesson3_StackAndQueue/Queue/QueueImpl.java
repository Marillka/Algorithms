package lesson3_StackAndQueue.Queue;

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

        //105 55
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return null;
    }
}
