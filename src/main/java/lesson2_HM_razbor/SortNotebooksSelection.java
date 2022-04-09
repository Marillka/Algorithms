package lesson2_HM_razbor;

import java.util.Comparator;
import java.util.List;

public class SortNotebooksSelection {

    // 1 вариант
    public static List<Notebook> sort(List<Notebook> notebooks) {
        int min = 0;
        for (int i = 0; i < notebooks.size() - 1; i++) {
            min = i;

            for (int j = i + 1; j < notebooks.size(); j++) {
                if (notebooks.get(j).compareTo(notebooks.get(min))< 0) {
                   min = j;
                }
            }
            if (i == min) {
                continue;
            }
            Notebook temp = notebooks.get(i);
            notebooks.set(i, notebooks.get(min));
            notebooks.set(min, temp);
        }

        return notebooks;
    }

    // 2 вариант
    //Этот метод пользуется методом compareTo(), который есть у ноутбука
    public static void sortLight(List<Notebook> notebooks) {
        // получаем компаратор. Компаратор получается на основе класса, реализующего интерфейс Comparable. И дальше мы просто указываем в каком порядке и что вообще у нас будет этот компаратор сравнивать. В первую очередь будет сравнивать у ноутбуков цену (цену получаем путем указателя на метод получения цены (все тоже самое можно заменить на лямбду или анонимный класс).
        Comparator<Notebook> c = Comparator.comparing(Notebook::getPrice)
                .thenComparing(Notebook::getMemory)
                .thenComparing(Notebook::getProducer);
        notebooks.sort(c);
    }

}
