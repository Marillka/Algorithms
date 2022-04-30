package lesson4_СвязанныеСписки;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TestMain4 {

    public static void main(String[] args) {
//        testLinkedList();
//        testHomeWork();
//        testIterator();

        var linkedList = new SimpleLinkedListImpl<>();

        linkedList.insertFirst(0);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertFirst(9);
        linkedList.insertFirst(10);
        linkedList.insertFirst(11);
        linkedList.insertFirst(12);

        linkedList.display();
        System.out.println(linkedList.size());

        linkedList.insert(111,6);
        linkedList.display();

        linkedList.insert(112,8);

        linkedList.display();


    }

    private static void testLinkedList() {

//        var linkedList = new SimpleLinkedListImpl<>();
        var linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);

        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        System.out.println("remove first: " + linkedList.removeFirst());
        linkedList.remove(4);
        linkedList.remove(11);

        linkedList.display();

        /* SIMPLELINKEDLIST
[8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1]
Find 2: true
Find 1: true
Find 4: true
Find 4444: false
remove first: 8
[7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1]


[8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1]
Find 2: true
Find 1: true
Find 4: true
Find 4444: false
remove first: 8
[7 -> 6 -> 5 -> 3 -> 2 -> 1]
 */

/*TWOSIDELINKEDLIST
[8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 9 -> 10 -> 11]
Find 2: true
Find 1: true
Find 4: true
Find 4444: false
remove first: 8
[7 -> 6 -> 5 -> 3 -> 2 -> 1 -> 9 -> 10]

 */

    }


    private static void testHomeWork() {

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();

        // ДОЛЖНО РАБОТАТЬ
//        for (Integer value : linkedList) {
//            System.out.println("value " + value);
//        }
    }

    private static void testIterator() {
        List<Integer> linkedList = new java.util.LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7, 8, 9);

//        for (Integer integer : linkedList) {
//            System.out.println(integer);
//        }
        //
        /*
        Итератор - внутренний класс, реализуемый в каждой структуре данных, с помоьщю которого конструкции подобного типа (foreach) будут заниматься перебором всех элементов внутри.
        Итератор это внутренний объект, который знает как перебирать структуру данных, он знает все методы. Вы там прописываете как он будет перепрыгивать от одного ко второму и так далее.
        У linkedList-а уже есть этот самый итератор.
         */

        // обратимся к структуре данных (List) и получим из нее итератор (сгенерирует новый и вернет нам его чтобы мы могли с ним поработать).
        ListIterator<Integer> iterator = linkedList.listIterator();

        //невявно срабатывает обнуление итератора

        // ПЕРЕДЕЛАТЬ !!! НЕ РАБОТАЕТ ПРАВИЛЬНО
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer + " до него " + iterator.previous());
            iterator.next();

            if (!iterator.hasNext()) {
                break;
            }
        }
    }



}


