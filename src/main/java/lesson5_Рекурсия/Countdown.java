package lesson5_Рекурсия;
/*
Вывод числе на экран. Задача подчитать от и до.
 */
public class Countdown {
    public static void main(String[] args) {
        countdown(5);// 5 4 3 2 1
    }

    private static void countdown(int n) {
        // базовый случай
        if (n < 1) {
            return;
        }

        System.out.println(n);
//        countdown(n - 1);
        countdown(--n);// Зависнем в рекурсии, пока она не остановится
        System.out.println("End n: " + n);
    }

    /*
5
4
3
2
1
     */
    /*
5
4
3
2
1
End n: 0
End n: 1
End n: 2
End n: 3
End n: 4
     */
}
