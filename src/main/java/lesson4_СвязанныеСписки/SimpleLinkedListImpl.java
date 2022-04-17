package lesson4_СвязанныеСписки;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    /*
    Интерфейс iterable позволяет сказать компилятору, что мы можем перебирать эту структура данныхю. Для этого надо добавить абсрактный интерфейс итератор
     */

    // ссылка на самый первый элемент. SimpleLinkedList - и есть та самая точка входа.
    protected Node<E> first;
    // Количество всех элементов в нашей структуре
    protected int size;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;// удаляемый узел
        first = removedNode.next;
        removedNode.next = null;// убираем связь у удаленного элемента
        size--;// уменьшаем размер листа

        return removedNode.value;// возвращаем значение удаленного узла.
    }

    @Override
    public boolean remove(E value) {

        Node<E> prev = null;
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;


        return true;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
    }

    // побочный метод для использования в contains().
    private Node<E> indexOf(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }

        return null;
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.value;
    }

    // должен создавать здесь экземпляр итератора
    public Iterator<E> iterator() {
        return  null; /*new ListIterator<E>();*/
    }

    private class ListIterator<E> implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        //reset();
    }
}
