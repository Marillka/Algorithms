package lesson5_Рекурсия;

import java.util.LinkedHashSet;
import java.util.Set;

/*
Анаграма. Нам необходимо подсчитать сколько различных слов можно сотавить из переденного слова.
abc     0(n!) 3! = 6

abc
cba
bca
acb
cab
bac
 */
public class Anagram {
    private Set<String> resultSet = new LinkedHashSet<>();
    private char[] chars;


    public static void main(String[] args) {

        System.out.println(new Anagram().findAll("aabb"));
        /*
       ab [ab, ba]

      abc  [abc, acb, bca, bac, cab, cba]

      abcd  [abcd, abdc, acdb, acbd, adbc, adcb, bcda, bcad, bdac, bdca, bacd, badc, cdab, cdba, cabd, cadb, cbda, cbad, dabc, dacb, dbca, dbac, dcab, dcba]

     abcde   [abcde, abced, abdec, abdce, abecd, abedc, acdeb, acdbe, acebd, acedb, acbde, acbed, adebc, adecb, adbce, adbec, adceb, adcbe, aebcd, aebdc, aecdb, aecbd, aedbc, aedcb, bcdea, bcdae, bcead, bceda, bcade, bcaed, bdeac, bdeca, bdace, bdaec, bdcea, bdcae, beacd, beadc, becda, becad, bedac, bedca, bacde, baced, badec, badce, baecd, baedc, cdeab, cdeba, cdabe, cdaeb, cdbea, cdbae, ceabd, ceadb, cebda, cebad, cedab, cedba, cabde, cabed, cadeb, cadbe, caebd, caedb, cbdea, cbdae, cbead, cbeda, cbade, cbaed, deabc, deacb, debca, debac, decab, decba, dabce, dabec, daceb, dacbe, daebc, daecb, dbcea, dbcae, dbeac, dbeca, dbace, dbaec, dceab, dceba, dcabe, dcaeb, dcbea, dcbae, eabcd, eabdc, eacdb, eacbd, eadbc, eadcb, ebcda, ebcad, ebdac, ebdca, ebacd, ebadc, ecdab, ecdba, ecabd, ecadb, ecbda, ecbad, edabc, edacb, edbca, edbac, edcab, edcba]

   aabb  [aabb, abba, abab, bbaa, baab, baba]

         */

    }

    /*
     будет отдввать множество новых слов.
     Множество потому что в случае с abc мы получим 6 слов абсолютно уникальных, а в случае aabb будут варианта aabb, aabb, aabb....
     Ну или aaa - aaa, aaa, aaa ....
     Кароче чтобы отсеить повторяющиеся случаи.
     */

    private Set<String> findAll(String word) {
        resultSet.clear();

        chars = word.toCharArray();

        /*
         Длинну слова передаем для того чтобы понимали какой будет сдвиг по буквам, когда у нас начинается этот метод.
         Самый первый раз это будет длинна слова. То есть если будет abc, то мы перебираем и сдвигаем все буквы полностью.
         */
        find(chars.length);

        return resultSet;
    }


    // здесь проходимя по всем буквам
    private void find(int length) {
        // базовый случай, если длинна = 1, то сдвигать ничего не нужно и выходим с ретерном
        if (length == 1) {
            return;
        }
        // если длинна не равна единице, то проходимся по каждой букве и для каждой буквы будет исполнять rotate().
        for (int i = 0; i < length; i++) {
            // добавляем первоначальный вариант букв в наш сет. Здесть идет только самый первый перебор abc = abc, cab, bca. Как только будет найден первый вариант для него сразу будет рекурсия (сверху).

            // здесь для каждого найденного слова запускаем тот же метод, но уже со сдвигом на единицу меньше
            find(length - 1);

            resultSet.add(String.valueOf(chars));
            rotate(length);
        }
    }

    // здесь выполняем сдвиги. length - сколько именно букв будут сдвигаться.
    private void rotate(int length) {
        int first = chars.length - length;
        char temp = chars[first];

        //сам сдвиг
        for (int i = first + 1; i < chars.length; i++) {
         chars[i - 1] = chars[i];
        }
        // на последнюю позицию кладем элемент, который мы заранее сохранили
        chars[chars.length - 1] = temp;

    }
}
