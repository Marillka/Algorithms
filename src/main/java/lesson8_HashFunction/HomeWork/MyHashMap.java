package lesson8_HashFunction.HomeWork;

class MyHashMap<K, V> {

    private Entry<K, V>[] data;// массив для хранения внутренних элементов
    private int capacity = 16;// начальная емкость массива

    // Внутренний элемент массива
    // Содержит ключ, значени и ссылку на следующий элемент
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        data = new Entry[capacity];
    }



    public void put(K key, V value) {

        // если пихают пустышку
        if (key == null)
            return;

        // считаем хеш ключа
        int hash = hashFunc(key);

        // Создаем экземпляр внутреннего элемента массива. Ссылку на следующий оставляем null.
        Entry<K, V> newEntry = new Entry(key, value, null);

        // Если в массиве ячейка пустая, то закидываем туда наш элемент
        if (data[hash] == null) {
            data[hash] = newEntry;
            // если же занята то создаем 2 новых entry.
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = data[hash];// текущий, который уже лежит в массиве

            // в цикле бежим до тех пор пока у текущая не равна null, то есть бежим до послденей entry.
            while (current != null) {

                if (current.key.equals(key)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        data[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;// предыдущая = текущей
                current = current.next;// текущая = null или следующая за текущей.
            }
            // добавляем новую entry за уже существуюещей
            previous.next = newEntry;
        }
    }

    public V get(K key) {
        // считаем хеш ключа
        int hash = hashFunc(key);

        // если ячейка пустая
        if (data[hash] == null) {
            return null;
        } else {
            // берем entry
            Entry<K, V> temp = data[hash];

            //  в цикле пробегаемся по всем entry пока не наткнемся на последнюю.
            while (temp != null) {
                // берем ту, ключ которой совпадает
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; // для пробежки по циклу
            }
            // если такого элемента не существует
            return null;
        }
    }

    public boolean remove(K deleteKey) {

        // считаем hash
        int hash = hashFunc(deleteKey);

        // если пустая
        if (data[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = data[hash];

            while (current != null) { // идем до последней entry
                if (current.key.equals(deleteKey)) {

                    if (previous == null) { // если предыдущий равен null - значит удаляется единственный элемент
                        data[hash] = data[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null) {
                Entry<K, V> entry = data[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + " = " + entry.value + "}" + " \n");
                    entry = entry.next;
                }
            }
        }
    }
}