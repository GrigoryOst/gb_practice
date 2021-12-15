import java.util.Random;

/*Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. 
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
Создайте два класса: беговая дорожка и стена, при прохождении через которые, 
участники должны выполнять соответствующие действия (бежать или прыгать), 
результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий. */

public class Main {


    public static void main(String[] args) {
        team();

    }

    private static void team () {


        Members human1 = new Man();
        Members cat1 = new Cat();
        Members robot1 = new Robot();
        Random random = new Random();

        Obstacle wall1 = new Wall(random.nextInt(500));
        Obstacle run1 = new RaceTrack(random.nextInt(10000));

        Members[] members1 = {human1, cat1, robot1};
        Obstacle[] obstacles1 = {wall1, run1};

        battle(members1, obstacles1);

        System.out.println("Победила Дружба!");
    }

    static void battle (Members run[], Obstacle obstacle[]) {
        for (int i = 0; i < run.length; i++) {
            for (int j = 0; j < obstacle.length; j++) {
                if (!obstacle[j].attempt(run[i])) {
                    System.out.println(run[i] + " вышел из гонки!");
                    if (run.length == (i+1)) {
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

    }
}
