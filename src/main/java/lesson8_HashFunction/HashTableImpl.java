package lesson8_HashFunction;

import java.util.Arrays;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private final Item<K, V>[] data;// массив с внутреними элементами
    private final Item<K, V> emptyItem; // заглушка для удаленного элемента
    private int size;

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("key: %s -> value: %s", key, value);
        }
    }




    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
        emptyItem = new Item<>(null, null);
    }

    public HashTableImpl() {
        this(16);
    }


//    @Override
//    public boolean put(K key, V value) {
//        if (size() == data.length) {
//            return false;
//        }
//
//        int iFromHashFunc = hashFunc(key);// получение хеш-кода элемента. Index after hash function.
//         int n = 0;// нужна для квадратичных прыжков
//
//        // Если добавляется точно такой же ключ, то мы берем и меняем его значение.
//        // Далее если у нас такого ключа нет, но у нас есть коллизия и в ячейку, куда мы пытаемся добавить уже что то хранится, то мы перейдем на следующую ячейку и в ней будем проверять есть ли в ней что то .
//        while (data[iFromHashFunc] != null && data[iFromHashFunc] != emptyItem) {
//            if (isKeysEquals(data[iFromHashFunc], key)) {
//                data[iFromHashFunc].setValue(value);
//                return true;
//            }
//            // в случае если ячейка занята идем дальше по ячейкам вправо
////            iFromHashFunc += getStepLinear();// метод нужен чтобы не выйти за пределы массива.
////            iFromHashFunc += getStepQuadratic(n++);// квадратичное
//            iFromHashFunc += getDoubleHash(key);// двойное хеширование
//
//            iFromHashFunc %= data.length;
//        }
//
//        data[iFromHashFunc] = new Item<>(key, value);
//        size++;
//
//        return true;
//    }


    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int iFromHashFunc = hashFunc(key);// получение хеш-кода элемента. Index after hash function.
//        int n = 0;// нужна для квадратичных прыжков

        // Если добавляется точно такой же ключ, то мы берем и меняем его значение.
        // Далее если у нас такого ключа нет, но у нас есть коллизия и в ячейку, куда мы пытаемся добавить уже что то хранится, то мы перейдем на следующую ячейку и в ней будем проверять есть ли в ней что то .
        while (data[iFromHashFunc] != null && data[iFromHashFunc] != emptyItem) {
            if (isKeysEquals(data[iFromHashFunc], key)) {
                data[iFromHashFunc].setValue(value);
                return true;
            }
            // в случае если ячейка занята идем дальше по ячейкам вправо
//            iFromHashFunc += getStepLinear();// метод нужен чтобы не выйти за пределы массива.
//            iFromHashFunc += getStepQuadratic(n++);// квадратичное
            iFromHashFunc += getDoubleHash(key);// двойное хеширование

            iFromHashFunc %= data.length;
        }

        data[iFromHashFunc] = new Item<>(key, value);
        size++;

        return true;
    }


    // Двойное хеширование не зависит от каких то заранее заданных показателей которые туда приходят. Расстояние на которое будет совершенн прыжок завист только лишь от самого ключа. То есть мы обратимся к ключу, получим при этом hashcode этого ключа, произвидем hash - функцию (найдем остаток от деления) и на основании этого случайным образом получится какое то значение.
    private int getDoubleHash(K key) {
        // берется любая константа, длинна которой не больше длинны нашего массива.
        int n = data.length / 2;
        return n - (key.hashCode() % n);
        // в итоге получаем, что теперь каждый раз возрат будет разным и зависит он лишь только от ключа. И при этом последовательность прыжков будет одна и таже, с какой бы части массива мы не прыгнули.
    }

    private int getStepQuadratic(int i) {
        return (int) Math.pow(i, 2);// возведение в квадрат
    }

    private int getStepLinear() {
        return 1;
    }

    // метод , чтобы понять идентичны ли 2 ключа.
    private boolean isKeysEquals(Item<K,V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        // сначала проверяем не равен ли ключ null, если равен -  возвращаем null, если не равен - сравниваем 2 ключа.
        return (item.getKey() == null) ? (key == null) : (item.getKey().equals(key));
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length); //  модуль для того чтобы мы не прыгнули в какой то несуществующий индекс. Такая же хеш-функция исплольуется в реальных хеш таблицах.

    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : data[index].getValue();
    }

    private int indexOf(K key) {
        int indexFromHashFunc = hashFunc(key);

        int count = 0;
        while (count++ < data.length) {
            if (data[indexFromHashFunc] == null) {
                break;
            }
            if (isKeysEquals(data[indexFromHashFunc], key)) {
                return indexFromHashFunc;
            }
            indexFromHashFunc += getDoubleHash(key);
            indexFromHashFunc %= data.length;// метод для того чтобы остаться в пределах массива. Когда доходим до конца - возвращаемся в начало.
        }

        return  -1;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        Item<K, V> removed = data[index];
        data[index] = emptyItem;

        return removed.getValue();

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
