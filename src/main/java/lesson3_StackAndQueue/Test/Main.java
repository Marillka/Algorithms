package lesson3_StackAndQueue.Test;


import lesson3_StackAndQueue.BinarySearch;
import lesson3_StackAndQueue.ExponentialSearch;
import lesson3_StackAndQueue.InterpolationSearch;

public class Main {
    public static void main(String[] args) {
        MyArray.isRepeat = false;
        MyArray.isShuffle = false;
        final int SIZE = 1_000_000;
        Integer[] arr = MyArray.getArray(SIZE, 2);

        final int NUM2FIND = 500_000;

        // ТЕСТ БИНАРНОЙ СОРИРОВКИ.
//        System.out.println(Arrays.toString(arr));
        System.out.println(BinarySearch.search(arr, NUM2FIND));

        System.out.println();

        // ТЕСТ ЭСПОНЕНЦИАЛЬНОЙ СОРИТРОВКИ.
        System.out.println(ExponentialSearch.search(arr, NUM2FIND));

        System.out.println();

        // ТЕСТ ИНТЕРПОЛЯЦИОННОЙ СОРТИРОВКИ
        System.out.println(InterpolationSearch.search(arr, NUM2FIND));

    }

    /*
    Base: 25000
Base: 37500
Base: 43750
Base: 40625
Base: 39062
Base: 39843
Base: 40234
Base: 40038
Base: 40136
Base: 40185
Base: 40160
Base: 40172
Base: 40178
Base: 40175
Найдено! Кол-во итераций: 14
40175

ЭП закончен. Итерраций: 16, от 32769, до 49999
Base: 41384
Base: 37076
Base: 39230
Base: 40307
Base: 39768
Base: 40037
Base: 40172
Base: 40239
Base: 40205
Base: 40188
Base: 40180
Base: 40176
Base: 40174
Base: 40175
Найдено! Кол-во итераций: 14
40175

Base: 40111
Base: 40177
Base: 40175
Найдено! Кол-во итераций: 3
40175

     */
}
