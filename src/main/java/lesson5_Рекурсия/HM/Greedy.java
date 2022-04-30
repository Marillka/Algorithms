package lesson5_Рекурсия.HM;

import java.util.ArrayList;
// не работает
public class Greedy {

    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};// вес предметов
        int[] prices = {1, 6, 4, 7, 6};// цена предметов

        int maxWeight = 13;// размер рюкзака

        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int resultWeight = 0;

        // индексируем
        for (int i = 0; i < weights.length; i++) {
            indexes.add(i);
        }

        while (!indexes.isEmpty()) {
            int maxValue = prices[indexes.get(0)];
            int maxIndex = indexes.get(0);

            for (int i = 0; i < indexes.size(); i++) {
                if (maxValue < prices[indexes.get(i)]) {
                    maxValue = prices[indexes.get(i)];
                    maxIndex = indexes.get(i);
                }
            }

            resultWeight += weights[maxIndex];
            if (resultWeight > maxWeight) {
                break;
            }

            result.add(maxIndex);
            indexes.remove(maxIndex);
        }

        System.out.println("Оптимальное содержимое рюкзака");
    }



}
