package lesson4_СвязанныеСписки;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);// вставка в конец

    E getLast();// получение последнего элемента
}
