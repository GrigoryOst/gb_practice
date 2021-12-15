import java.util.Scanner;

/*1. Содать классы кот и тарелка, создать их объекты или массивы объектов в зависимости от задачи
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/

public class Main {

    public static void main(String[] args) {
        catsVsPlate();

    }

    public static void catsVsPlate () {
        Scanner scanner = new Scanner(System.in);
        Plate plate = new Plate(100);
        plate.checkFood();
        int addFood;
        Cat [] cats = new Cat[3];
        cats[0] = new Cat("Борис", 50, false);
        cats[1] = new Cat("Степан", 25, false);
        cats[2] = new Cat("Владимир", 30, false);
        for (Cat cat : cats) {
            if (!cat.satiety && cat.getAppetite() < plate.getFood()) {
                cat.eat(plate);
                cat.satiety = true;
                System.out.println("Кот " + cat.name + " поел, показатель сытости " + cat.satiety);
            } else {
                System.out.println("Кот " + cat.name + " не успел поесть, показатель сытости " + cat.satiety);
            }
        }
        plate.checkFood();
        System.out.println("Сколько добавить корма что бы все коты были сыты?");
        addFood = scanner.nextInt();
        plate.moreFood(addFood);
        plate.checkFood();
        for (Cat cat : cats) {
            if (!cat.satiety && cat.getAppetite() < plate.getFood()) {
                cat.eat(plate);
                cat.satiety = true;
                System.out.println("Кот " + cat.name + " поел, показатель сытости " + cat.satiety);
            } else {
                System.out.println("Кот " + cat.name + " не успел поесть, показатель сытости " + cat.satiety);
            }
        }
        System.out.println("Все коты довольны!");
    }
}
