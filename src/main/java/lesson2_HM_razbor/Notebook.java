package lesson2_HM_razbor;



import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class Notebook implements Comparable<Notebook> {
    BigDecimal price;// цена в BigDecimal, потому что все цены храняться в данном формате.
    int memory;// память
    Producer producer;// enum производителей
    UUID serialId = UUID.randomUUID();// рандомный серийный номер

    public enum Producer {
        // сразу провисывается та очередность, по которой будет производиться сортировка.
        XAMIOU, ESER, MACNOTE, ASOS, LENUVO
    }


    // метод компаратора, который позволяет сравнивать 2 экземпляра друг друга
    // Здесь используются getPrice(), getMemory(), getProducer(), хотя таких методов нет. Это потому что используется аннотация @Value. Это библиотека loombok*, которая позволяет генерировать множество кода за вас(нужно подключить в зависимости в помнике). В частности генерировать все дополнительные методы.
    @Override
    public int compareTo(Notebook n) {
        // результат сравнения двух цен.
        int result = price.compareTo(n.getPrice());
        // если цена одинакова - сравнимаем память
        if (result == 0) {
            result = Integer.compare(memory, n.getMemory());
            // если память одинаковая - сравниваем производителя
            if (result == 0) {
                return producer.compareTo(n.getProducer());
            }
            return result;
        }
        return result;
    }

}
