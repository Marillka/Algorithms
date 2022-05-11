package lesson8_HashFunction.gb_Manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Item {
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}

class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }
}

public class HashApp {
    public static void main(String[] args) throws IOException {
        Item aDataItem;
        int aKey, size, n, keysPerCell;

        // Ввод размеров
        System.out.println("Enter size of hash table: ");
        size = getInt();
        System.out.println("Enter initial number of items");
        n = getInt();

        keysPerCell = 10;
        // Создание таблицы
        HashTable theHashTable = new HashTable(size);
        for (int j = 0; j < n; j++) {
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new Item(aKey);
            theHashTable.insert(aDataItem);
        }
        while (true) {
            System.out.println("Enter first letter of ");
            System.out.println("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.display();
                    break;
                case 'i':
                    System.out.println("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Item(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.println("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.println("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else {
                        System.out.println("Could not find " + aKey);
                        break;
                    }
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
