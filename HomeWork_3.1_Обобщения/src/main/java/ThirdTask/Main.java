package ThirdTask;

/*a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.*/

public class Main {

    public static void main(String[] args) {
        work();
    }

    public static void work() {
        Orange orange = new Orange();
        Apple apple = new Apple();

        Box<Orange> boxOfOrange = new Box(new Orange(), new Orange(), new Orange());
        Box<Apple> boxOfApple1 = new Box(new Apple(), new Apple());
        Box<Apple> boxOfApple2 = new Box();

        boxOfOrange.info();
        boxOfApple1.info();
        boxOfApple2.info();
        System.out.println();

        System.out.println("Box weight with oranges: " + boxOfOrange.getWeight() + "\n"
                + "Box weight with apples1: " + boxOfApple1.getWeight() + "\n"
                + "Box weight with apples2: " + boxOfApple2.getWeight());
        System.out.println(boxOfOrange.compare(boxOfApple1) + "\n");

        boxOfApple1.replace(boxOfApple2);

        boxOfOrange.info();
        boxOfApple1.info();
        boxOfApple2.info();
    }
}
