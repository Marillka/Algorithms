package lesson6_Trees.lesson;

public interface Tree<E extends Comparable<? super E>> {

    // нужно для обхода дерева
    enum TraverMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    // наличие элемента
    boolean contains(E value);

    // добавление элемента
    boolean add(E value);

    // удаление элемента
    boolean remove(E value);

    // проверка на пустоту
    boolean isEmpty();

    // размер
    int size();

    // вывод
    void display();

    // метод для обхода дерева. Проход по каждому элементу от и до.
    void traverse(TraverMode mode);
}
