package lesson5_Рекурсия.HM;

// алгоритм полного пербора
public class Bruteforce {
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int maxWeight = 13;// размер рюкзака

        long count = 2L << weights.length;// 2 в степени количество предметов

        int maxPrice = 0;
        long maxState = 0;

        for (long state = 0; state < count; state++) {
            int price = statePrice(state, prices);
            int weight = stateWeight(state, weights);
            if (weight <= maxWeight) {
                if (maxPrice < price) {
                    maxPrice = price;
                    maxState = state;
                }
            }
        }

        System.out.println("Оптимальное содержимое рюкзака");
        long powerOfTwo = 1;
        for (int i = 0; i < weights.length; i++) {
            if ((powerOfTwo & maxState) > 0) {
                System.out.println(i + 1);
            }
            powerOfTwo <<= 1;
        }
    }


    // вес набора элементов
    private static int stateWeight(long state, int[] weights) {
        long powerOfTwo = 1;
        int weight = 0;
        for (int i = 0; i < weights.length; i++) {
            if ((powerOfTwo & state) != 0) {
                weight += weights[i];
            }
            powerOfTwo <<= 1;
        }
        return weight;
    }

    // стоимость набора предметов
    private static int statePrice(long state, int[] prices) {
        long powerOfTwo = 1;
        int price = 0;
        for (int i = 0; i < prices.length; i++) {
            if ((powerOfTwo & state) != 0) {
                price += prices[i];
            }
            powerOfTwo <<= 1;
        }
        return price;
    }

}
