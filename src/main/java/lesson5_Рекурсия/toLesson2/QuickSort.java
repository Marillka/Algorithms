package lesson5_Рекурсия.toLesson2;

/*
 5 2 4 1 3 7 5 9 11 0 1 12
 [2 4 1 3 0 1]           [5 5] [7 9 11 12]                  1
 [1 0 1]       [2]     [4 3]      [][7][9 11 12]            2
[0] [1 1]          [3] [4]              []9[11 12]          3
0                      3                   []11[12]         4
                                               12           5
 */

import java.util.*;

public class QuickSort {
    public static List<Integer> quickSort(List<Integer> arr) {
        // базовый случай. Если приходящий список полностью пустой
        if (arr.isEmpty()) {
            return arr;
        }

        // определение базового элемента
        Integer base = arr.get(0);

        // после чего создаем 3 списка
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        //бежим по всем элементам массива
        for (Integer n : arr) {
            if (n == base) {
                middle.add(n);
            } else if (n.compareTo(base) > 0) {
                right.add(n);
            } else {
                left.add(n);
            }

        }

        // после того как получили 3 списка, мы должны также эти 3 списка отсортировать

        // рекурсия. здесь вернется полностью отсортированный массив левой части.
        left = quickSort(left);
        // тоже для правой
        right = quickSort(right);

        // дальше склеиваем все 3 массива в один. В конец левого добавляем центральный и далее настоящий добавляем правый в конец.
        left.addAll(middle);
        left.addAll(right);

        return left;
    }

    // берет массив и гонит в лист
    public static void sort(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);

        quickSort(list).toArray(arr);
    }
}
