package lesson2_HM_razbor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSort {

    private static final int NOTEBOOKS_COUNT = 50_000;

    public static void main(String[] args) {

        List<Notebook> notebooks = generateListNotebooks();

        long timeStart = System.currentTimeMillis();

        // способ 1 - сортировка выбором
        notebooks = SortNotebooksSelection.sort(notebooks);

        // способ 2 - сортировка компаратором


        // способ 3 - сортировка быстрая


        long timeEnd = System.currentTimeMillis();

        displayNotebooks(notebooks);
        System.out.printf("Прошло времени: %dms", timeEnd - timeStart);
    }



    public static void displayNotebooks(List<Notebook> list) {
        for (Notebook n : list) {
            System.out.printf("Ноутбук: \tc\\н: %s,\tцена: %s, \tпамять: %s, \tпроизводитель: %s%n",
                    n.getSerialId(),
                    n.getPrice(),
                    n.getMemory(),
                    n.getProducer()
                    );
        }
    }


    /*
    Создаем массив путем заполнением множеством ноутбуков, которые создаются в методе createNotebook()
     */
    private static ArrayList<Notebook> generateListNotebooks() {
        ArrayList<Notebook> arrayList = new ArrayList<>();
        for (int i = 0; i < NOTEBOOKS_COUNT; i++) {
            arrayList.add(createNoteBook());
        }
        return arrayList;
    }

    private static Notebook createNoteBook() {
        Random random = new Random();
        // шаг по цене
        BigDecimal price = BigDecimal.valueOf(random.nextInt(26) * 100 + 500);
        // шаг по памяти
        int memory = (random.nextInt(6) + 1) * 4;
        // получение производителя случайным образом из ENUM
        int producersCount = Notebook.Producer.values().length;
        Notebook.Producer producer = Notebook.Producer.values()[random.nextInt(producersCount)];
        // создание экземпляра ноутбука
        return new Notebook(price, memory, producer);
    }
}
