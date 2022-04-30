package lesson5_Рекурсия.HomeWork;

public class Main2 {
    public static int[] weights = {4, 1, 3};
    public static int[] values = {4000, 2500, 2000};

    public static int CountMax(int[] weights, int[] values, int maxCapacity) {
        // строим массив и закладываем место на ячейки пустышки выходящие из левого верхнего угла
        int[][] arr = new int[weights.length + 1][maxCapacity + 1];

        // проходим по всем вещам
        for (int i = 0; i < weights.length; i++) {

            // проходим по всем рюкзакам
            for (int j = 0; j < maxCapacity; j++) {

                // попадаем в ячейку пустышку
                if (i == 0 && j == 0) {
                    arr[i][j] = 0;
                } else {
                    // если вес текущей вещи больше размера рюкзака
                    // казалось бы откуда возьмется для первой вещи
                    // при таком условии. Оно снова возьмется из ряда пустышки.
                    if (weights[i - 1] > j) {
                        arr[i][j] = arr[i - 1][j];
                    } else {
                        // здесь по формуле. Значение над текущей ячейкой
                        var prev = arr[i - 1][j];
                        // значение по вертикали: ряд вверх
                        // и по горизонтали: вес рюкзака - вес текущей вещи
                        var byFormula = values[i - 1] + arr[i - 1][weights[i - 1]];
                        arr[i][j] = Math.max(prev, byFormula);
                    }
                }

            }
        }

        return arr[weights.length][maxCapacity];
    }

    public static void main(String[] args) {
        System.out.println(CountMax(weights, values, 4));

    }
}
