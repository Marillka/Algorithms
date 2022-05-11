package lesson8_HashFunction.HomeWork;

public class Test {
    public static void main(String[] args) {
        MyHashMap<Product, Integer> map = new MyHashMap<>();

        map.put(new Product(1, "Orange"), 150);
        map.put(new Product(77, "Banana"), 100);
        map.put(new Product(67, "Carrot"), 228);
        map.put(new Product(60, "Lemon"), 250);
        map.put(new Product(51, "Milk"), 120);
        map.put(new Product(21, "Potato"), 67);

        map.display();

        System.out.println();

        System.out.println("Cost potato is " + map.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + map.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + map.get(new Product(67, "Carrot")));


        map.remove(new Product(21, "Potato"));
        map.remove(new Product(77, "Banana"));

        System.out.println();

        System.out.println("Cost potato is " + map.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + map.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + map.get(new Product(67, "Carrot")));


        map.put(new Product(47, "Pineapple"), 228);


        System.out.println();
        map.display();


    }
}
