package lesson3_StackAndQueue.Stack;

import lesson3_StackAndQueue.Queue.Queue;
import lesson3_StackAndQueue.Queue.QueueImpl;

public class Test3 {

    public static void main(String[] args) {
//        testStack();
        textQueue();
    }


    public static void testStack() {

        Stack<Integer> stack = new StackImpl<>(4);

        System.out.println(stack.push(12));
        System.out.println(stack.push(16));
        System.out.println(stack.push(22));
        System.out.println(stack.push(5));
        // не влезут
        System.out.println(stack.push(1));
        System.out.println(stack.push(32));

        stack.display();

        System.out.println("top value " + stack.pop());
        System.out.println("top value " + stack.peek());
        stack.display();

        /*
true
true
true
true
false
false
[5, 22, 16, 12]
top value 5
top value 22
[22, 16, 12]
         */

        /*
         Это может использоваться например в задачке про скобочки. Вариации разные. Например:
         У вас есть строка. В этой строке что то написанно. " пример: (7 - 5/3) / ([3-5] + 7).
         Вам нужно проверить - все ли скобочки написанны правильно. Нет ли где такого, что появляется какая то лишнаяя скобочка, или одна из скобочек не закрывается, то есть нужно провески валидацию всего что есть внутри.
         Для этого как раз таки существует стек.
         Вы идете и поочередно каждую скобочку добавляете в стек.
         Первой кладем открывающюю круглую, идем дальше, появляется закрывающая круглая. Угу. Если у нас есть закрывающая скобка, то для нее должна быть открывающая, а открывающая должна быть последняя которая лежит в стеке. Идем в стек ( там лежит открывающая), пришла закрывающая круглая. Ага значит все совпало и мы извлекаем открывающуюю скобку из стека и движемся дальше. Дальше в стек кладем открывающуую круглую, за ней открывающюю квадратную. Появляется закрывающая квадратная -> значит опять идем в стек, смотрим какая лежит на самой верхней позиции, если они совпадают (квадратная с квадратной), то извлекаем эту скобку из стека. И тоже самое с круглой. Стек пустой - значит все в порядке. Если бы хоть одна осталась или скобки разные - значит баланса нет.

         Еще стек может применяться для парсинга математических выражений. ПОСМОТРЕТЬ ВИДЕО НА КАНАЛЕ.
         Когда делали калькулятор со студентами Java. И чтобы перевести строку из калькулятора в математическое выражение, там показанно как это преобразовать.
         */

    }

    private static void textQueue() {
        Queue<Integer> queue = new QueueImpl<>(4);

        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));

        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();

        /*
add element: true
add element: true
add element: true
add element: true
add element: false
add element: false
[34, 12, 20, 16]
remove: 34
[12, 20, 16]
         */
    }


}
