package lesson5_Рекурсия;

/*
Факторил - все числа премноженные до текущего.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    private static long factorial (long n) {
        // базовый случай. Случай в котором у нас метод завершится окончательно и прервет рекурсию.
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);// это строчка называется рекурсионный случай. Он дает возможномть рекурсии как таковой быть и перезапуститься на еще один круг.
    }

    /*
    720
     */
}
