package lesson3_StackAndQueue.Queue;

public interface Queue<E> {

    boolean insert(E value);// добавление в конец

    E remove();// извлечение из начала

    E peekFront();// показывает первый элемент в очереди

    int size;

    boolean isEmpty;

    boolean isFull;

    void display;
}
