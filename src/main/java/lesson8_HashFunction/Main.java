package lesson8_HashFunction;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        HashTable<Product, Integer> hashTable = new HashTableImpl<>(5);

        hashTable.put(new Product(1, "Orange"), 150); //1
        hashTable.put(new Product(77, "Banana"), 100); //7
        hashTable.put(new Product(67, "Carrot"), 228); //8
        hashTable.put(new Product(60, "Lemon"), 250); //0
        hashTable.put(new Product(51, "Milk"), 120); //2
        hashTable.put(new Product(21, "Potato"), 67); //3

        System.out.println("Size is " + hashTable.size());
        hashTable.display();
        /*
        Линейные прыжки
        0 = [key: Product id=60, title='Lemon' -> value: 250]
        1 = [key: Product id=1, title='Orange' -> value: 150]
        2 = [key: Product id=51, title='Milk' -> value: 120]
        3 = [key: Product id=21, title='Potato' -> value: 67]
        4 = [null]
        5 = [null]
        6 = [null]
        7 = [key: Product id=77, title='Banana' -> value: 100]
        8 = [key: Product id=67, title='Carrot' -> value: 228]
        9 = [null]
         */

        /*
        Квадратичные прыжки
        0 = [key: (id=60, title='Lemon') -> value: 250]
        1 = [key: (id=1, title='Orange') -> value: 150]
        2 = [key: (id=51, title='Milk') -> value: 120]
        3 = [null]
        4 = [null]
        5 = [null]
        6 = [key: (id=21, title='Potato') -> value: 67]
        7 = [key: (id=77, title='Banana') -> value: 100]
        8 = [key: (id=67, title='Carrot') -> value: 228]
        9 = [null]
         */

        /*
        Двойное хеширование
       0 = [key: (id=67, title='Carrot') -> value: 228]
        1 = [key: (id=1, title='Orange') -> value: 150]
        2 = [null]
        3 = [key: (id=21, title='Potato') -> value: 67]
        4 = [null]
        5 = [key: (id=60, title='Lemon') -> value: 250]
        6 = [null]
        7 = [key: (id=77, title='Banana') -> value: 100]
        8 = [null]
        9 = [key: (id=51, title='Milk') -> value: 120]
         */
        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));


        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(77, "Banana"));

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        hashTable.put(new Product(47, "Pineapple"), 228);

        hashTable.display();

        /*
0 = [key: (id=67, title='Carrot') -> value: 228]
1 = [key: (id=1, title='Orange') -> value: 150]
2 = [null]
3 = [key: (id=21, title='Potato') -> value: 67]
4 = [null]
5 = [key: (id=60, title='Lemon') -> value: 250]
6 = [null]
7 = [key: (id=77, title='Banana') -> value: 100]
8 = [null]
9 = [key: (id=51, title='Milk') -> value: 120]

Cost potato is 67
Cost banana is 100
Cost carrot is 228
Cost potato is null
Cost banana is null
Cost carrot is 228

0 = [key: (id=67, title='Carrot') -> value: 228]
1 = [key: (id=1, title='Orange') -> value: 150]
2 = [null]
3 = [key: null -> value: null]
4 = [null]
5 = [key: (id=60, title='Lemon') -> value: 250]
6 = [null]
7 = [key: (id=47, title='Pineapple') -> value: 228]
8 = [null]
9 = [key: (id=51, title='Milk') -> value: 120]
         */

HashMap map = new HashMap();
    }
}
