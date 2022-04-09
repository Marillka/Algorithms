package lesson3_StackAndQueue.Stack;

public interface Stack<E> {

    boolean push(E value);//добавление нового элемента на последнюю позицию

    E pop();// извлечение последнего элемента (с возвратом значения

    E peek(); // top() в некоторых языка. Показывает какой именно элемент находится на последней позиции

    int size();// размер стека

    boolean isEmpty();// проверка пустой ли он

    boolean isFull();// проверка заполнен ли он

    void display();// вывод всего стека на экран
}
