package lesson4_СвязанныеСписки;

public interface LinkedList<E> {

    boolean insertFirst(E value);// добавление в самое начало

    boolean insert(E value, int number);// добавление

    E removeFirst();// удаление самого начала

    boolean remove(E value);// удаление

    boolean contains(E value);// проверка наличия элемента

    int size();// размер

    boolean isEmpty();// проверка на пустоту

    void display();// вывод

    E getFirst();// получение самого начала

    class Node<E> {
        E value;
        Node<E> next;// ссылка на слеюущий элемент с типом Node

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

    }

}
