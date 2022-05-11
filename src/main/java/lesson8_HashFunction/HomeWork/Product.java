package lesson8_HashFunction.HomeWork;

import java.util.Objects;

public class Product {
    private final int id;// На заметку!! поле id ВСЕГДА создается с типом данных long
    private final String title;// название продукта

    public Product(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Чтобы все грамотно работало надо переопределить hashCode.
    // HashCode переопределяется вместе с equals, потому что прямо сейчас HashCode по умолчанию (то что прописывается в Object) определяет хеш случайным образом на основе ссылки. Обслоютно 2 одинаковых экземпляра класса отдадут нам разные хеш значения, а такого быть не должно.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(id, title); // СТАНДАРТНЫЙ
        return id;
    }

    @Override
    public String toString() {
        return  "(id=" + id + ", title='" + title + "')";
    }
}
