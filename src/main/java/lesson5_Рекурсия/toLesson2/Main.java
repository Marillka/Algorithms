package lesson5_Рекурсия.toLesson2;

import lesson3_StackAndQueue.Test.MyArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArray.isRepeat = false;
        MyArray.isShuffle = true;
        final int SIZE = 50000;
        Integer[] arr = MyArray.getArray(SIZE, 2);


        long  time = System.currentTimeMillis();

//        System.out.println(Arrays.toString(arr));

//       QuickSort.sort(arr);// для 50 000 - 211
        MergeSort.sort(arr);//для 50 000 - 163

//        System.out.println(Arrays.toString(arr));

        System.out.println(System.currentTimeMillis() - time);
    }
}

/*
[11, 6, 20, 10, 21, 8, 14, 0, 3, 17]
[0, 3, 6, 8, 10, 11, 14, 17, 20, 21]
 */

