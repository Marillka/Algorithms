package lesson5_Рекурсия.HM;

import java.util.ArrayList;

public class Dynamic {

    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};// вес
        int[] prices = {1, 6, 4, 7, 6};// цена

        int count = weights.length;// размер набора предметов
        int maxWeight = 13; // вместимость рюкзака

        int[][] A ;
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxWeight + 1];
        }

        for (int k = 0; k <= count; k++) {// строки (предметы)
            for (int s = 0; s <= maxWeight; s++) {// столбцы (рюкзаки)
                // если размер набора предметов = 0 или размер рюкзака = 0
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    // если размер рюкзака больше или равне размеру текущего предмета. Предмет влезает
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k-1][s], A[k - 1][s - weights[k - 1] + prices[k - 1]]);
                    } else {// если предмет в рюкзак не влезает
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A, weights, count, maxWeight, result);

        System.out.println("Оптимальное содержимое рюкзака");
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    /* Передаем:
    - массив с оптимальной стоимостью A
    - веса предметов  weight
    - размер набора предметов k
    - размер рюкзака s
    - лист для хранения предметов из оптимального набора
     */
    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        // пустышка
        if (A[k][s] == 0) {
            return;
        }

        // еслм k предмет не участвует в крайней правой колонке снизу
        if (A[k - 1][s] == A[k][s]) {
            traceResult(A, weight,k -1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }

}
