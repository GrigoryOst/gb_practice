import java.util.Random;
import java.util.Scanner;

/*1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.*/

public class Main {

    private static char[][] gameMap;
    public static Scanner sc = new Scanner(System.in);

    private static final char EMPTY_DOT = '◙';
    private static final char X_DOT = 'X';
    private static final char O_DOT = '○';

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        initGameMap(3, 3);
        paintGameMap();
        int count = 0;
        while (true) {
            humanTurn();
            count++;
            paintGameMap();
            if (chekWin(X_DOT)) {
                System.out.println("You WIN!!!");
                break;
            }

            if (count == gameMap.length * gameMap[0].length) {
                System.out.println("-))) FRIENDLY WIN -)))");
            }

            computeTurn();
            count++;
            paintGameMap();
            if (chekWin(O_DOT)) {
                System.out.println("Sorry but you looser, computer WIN -((( ");
            }

            if (count == gameMap.length * gameMap[0].length) {
                System.out.println("-))) FRIENDLY WIN -)))");
            }

        }
    }

    private static boolean chekWin(char oDot) {
        checkDiagonal('x');
        checkLanes('y');
        return false;
    }

    private static boolean checkDiagonal(char symb) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i=0; i<3; i++) {
            toright &= (gameMap[i][i] == symb);
            toleft &= (gameMap[3-i-1][i] == symb);
        }

        if (toright || toleft) return true;
        return false;
    }

    private static void checkLanes(char symb) {
        boolean column, rows;
        for (int col=0; col<3; col++) {
            column = true;
            rows = true;
            for (int row=0; row<3; row++) {
                column &= (gameMap[col][row] == symb);
                rows &= (gameMap[row][col] == symb);
            }

            if (column || rows) return;
        }

    }


    private static void computeTurn() {
        System.out.println("Computer not a human, computer thinking");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        int x, y;
        boolean checkCell;
        Random random = new Random();
        do {
            x = random.nextInt(gameMap.length);
            y = random.nextInt(gameMap.length);
            checkCell = isValidCell(x, y);
        } while (!checkCell);
        gameMap[x][y] = O_DOT;
    }

    private static void humanTurn() {
        int x = -1;
        int y = -1;
        boolean checkCell;
        do {
            System.out.println("Пожалуйста введите координаты в формате X Y");
            if (sc.hasNextInt()) {
                x = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()) {
                y = sc.nextInt() - 1;
            }
            checkCell = isValidCell(x, y);
            sc.nextLine();
        } while (!checkCell);
        gameMap[x][y] = X_DOT;
    }

    private static boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > gameMap.length || y > gameMap[0].length) {
            return false;
        }
        return gameMap[x][y] == EMPTY_DOT;
    }

    private static void paintGameMap() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initGameMap(int length, int width) {
        if (length < 3 || width < 3) {
            System.out.println("You stupid man");
            System.exit(0);
        }
        gameMap = new char[length][width];
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                gameMap[i][j] = EMPTY_DOT;
            }
        }
    }
}

