import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static void main(String[] args) {
        System.out.println("Ваша задача угадать число.");
        Random random = new Random();
        int randNumber = random.nextInt(20);
        System.out.println("Угадайте число от 0 до " + randNumber);
        Scanner inpScanner = new Scanner(System.in);
        int input_number = inpScanner.nextInt();
        if (input_number > randNumber || input_number < randNumber) {
            for (int life = 3; life > 0; --life) {
                if (input_number > randNumber) {
                    System.out.println("Загаданное число больше! Осталось попыток " + life);
                    Scanner scanner1 = new Scanner(System.in);
                    int scannerTWO = scanner1.nextInt();
                    input_number = scannerTWO;
                } else if ( input_number < randNumber) {
                    System.out.println("Загаданное число меньше! Осталось попыток " + life);
                    Scanner scanner3 = new Scanner(System.in);
                    int scannerTHREE = scanner3.nextInt();
                    input_number = scannerTHREE;
                }
            }
            if ( input_number == randNumber) {
                System.out.println("ПОБЕДА");
            }
        }
        if ( input_number > randNumber || input_number < randNumber) {
            System.out.println("ПОРАЖЕНИЕ");
        }
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        do {
            int count = 0;
            int guess = -1;
            int number = random.nextInt(10);
            while (count < 3 && guess != number) {
                System.out.print("Guess the number (0..9): ");
                guess = sc.nextInt();
                if (number != guess) {
                    System.out.println("Your number is " + ((guess > number) ? "greater" : "less"));
                    count++;
                }
            } System.out.println("You " + ((guess == number) ? "WIN!" : "Lose: " + number));
            System.out.println("Repeat game? Yes - 1, No - 0");
        } while (sc.nextInt() == 1);






    }
}
