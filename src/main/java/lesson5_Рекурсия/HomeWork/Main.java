//package lesson5_Рекурсия.HomeWork;
//
//public class Main {
//    public static void main(String[] args) {
//
//        int things = 3;
//        int capacity = 3;
//
//        Item[] items = {
//                new Item("Гитара", 1, 1500),
//                new Item("Магнитовон", 4, 3000),
//                new Item("Ноутбук", 3, 20000)};
//
//
//        // массив промежуточных состояний рюкзака
//        Backpack[][] backpack = new Backpack[things + 1][capacity + 1];
//
//
//        // алгоритм заполнения таблицы
//        for (int i = 0; i < things + 1; i++) {// строки
//            for (int j = 0; j < capacity + 1; j++) {// столбы
//
//                //нулевую строку и столбец заполняем нулями
//                if (i == 0 && j == 0) {
//                    backpack[i][j] = new Backpack(new Item[]{}, 0);
//                } else if (i == 1) {
//                    // первая строка заполняется просто: первый предмет или не кладем в зависимости от веса.
//                    backpack[1][j] = items[0].getWeight() <= j ? new Backpack(new Item[]{items[0]}, items[0].getCost()) : new Backpack(new Item[]{}, 0);
//                } else {
//                    if (items[i - 1].getWeight() > j) {// если очередной предмет не влезает в рюкзак
//                        backpack[i][j] = backpack[i - 1][j];// записываем очередной максимум
//                    } else {
//                        // рассчитаем цену очередного предмета + максимальную цену для (максимально возможный для рюкзака вес - вес предмета)
//                        int newCost = items[i - 1].getCost() + backpack[i - 1][j - items[i - 1].getWeight()].getCost();
//                        if (backpack[i - 1][j].getCost)
//                    }
//                }
//            }
//        }
//
//
//    }
//
//}
