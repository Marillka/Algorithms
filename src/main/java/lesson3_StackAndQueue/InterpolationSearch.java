package lesson3_StackAndQueue;


/*
Очень похож на бинарный поиск. Вы берете какую нибудь книгу, допустим словарь.
Сейчас вы будете искать слово экскаватор. Будете ли вы искать букву Э в начале, в середине? Нет. ВЫ сразу бедуте понимать что она находится где то в конце, и вам потребуется с самого - самого конца открыть словарь, и уже там прикидывать куда двигаться.
Этот поиск будет рассчитываеть теоретическую позицию в массиве, основываясь на плотность значений в этом массиве и прыгать на предполагаемую позицию.
У него будет start end base.
Отличается от бинарного 2 моментами. 1) То каким образом выходить из этого цикла, потому что есть ньюанс, что в процессе расчета base может выпрагнуть из диапазона start и end (для этого число которое мы ищем, всегда должно находиться в пределах start и end. Будем вычислять сколько ячеек приходится на одну единицу значения. 1 3 4 7 количество делим на сумму этих чисел, тем самым получая количество ячеек на одну единицу значения. = 4/15 = ... Имея это значение может найти число в диапазоне. Умножаем 4/15 на номер элемента в массиве. Будет ввести очеь очень близко к числу, которое ищем).
base = start + плотность элементов.
2) Так как используем деление. Нужно продумать: если разница между start и end будет равняться 0.

Сложностсь O( log log n) - логарифм от логарифма n. То есть усли у нас кол-во шаго будет равняться 16 как в бинарном поиске, то interpolation максимум выполнит это все за 4. 10^2 -> 40 шагов -> 6 шагов.

Но ложка тегня - распределенность значений в массиве. Если у нас массив 1 10 12 17 40 150 - мы не сможем нормально искать (все будет склонятся к первому индексу).
Не имеет смылс в этом поиске если диапазоны скачут. Он особо эффективен
*/
public class InterpolationSearch {

    public static int search(Integer[] arr, int num2Find) {
        return search(arr, num2Find, 0, arr.length - 1);
    }

    public static int search(Integer[] arr, int num2Find, int start, int end) {
        /* int start = 0;
        int end = arr.length - 1;*/
        int base;

        int i = 0;

        // в условие всегда должны проверять, что число, которое хотим найти хранится в диапазоне, который мы выбрали
        while (end >= start && num2Find >= arr[start] && num2Find <= arr[end]) {
            i++;
            if (arr[end].equals(arr[start])) {
                break;
            }
            base = (int) (start +
                    1.0 * (end - start) / (arr[end] - arr[start])
                            * (num2Find - arr[start]));
            System.out.println("Base: " + base);

            if (arr[base] == num2Find) {
                System.out.println("Найдено! Кол-во итераций: " + i);
                return base;
            } else if (arr[base] < num2Find) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        if (arr[start].equals(num2Find)) {
            System.out.println("Найдено! Кол-во итераций: " + i);
            return start;
        }

        System.out.println("Не нашли. Кол-во итераций: " + i);
        return -1;
    }

}
