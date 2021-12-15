import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.*/

public class Main {

    public static void main(String[] args) {
        example();
    }

    public static void example () {
        String[] words = {"Smile",
                "Second",
                "JAVA",
                "Window",
                "Boris",
                "JAVA",
                "Deftones",
                "Devil",
                "Rubicon",
                "Smile",
                "Defeater",
                "Future",
                "Cold"};
        HashMap<String,Integer> hm = new HashMap<>();
        for (String word : words) {
            Integer res = hm.get(word);
            hm.put(word, res == null ? 1 : res + 1);
        }

        System.out.println(hm);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79991774415");
        phoneBook.add("Петров", "+79991774416");
        phoneBook.add("Сидоров", "+79991774417");
        phoneBook.add("Иванов", "+79991774418");
        phoneBook.add("Зубов", "+79991774419");
        phoneBook.add("Волк", "+79991774420");
        phoneBook.add("Зубов", "+79991774421");
        phoneBook.add("Второй", "+79991774422");

        phoneBook.info();

        System.out.println(" У Зубова номера: " + phoneBook.get("Зубов"));
    }
}
