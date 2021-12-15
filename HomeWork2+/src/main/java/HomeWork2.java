public class HomeWork2 {

    public static void main (String[] args) {
        firstWork ();
        System.out.println();
        secondWork ();
        System.out.println();
        thirdWork ();
        System.out.println();
        fourthWork ();
        System.out.println();
        fifthWork ();
    }

    /*Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. 
    С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    public static void firstWork () {
        int[] mass1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            for (int i = 0; i < mass1.length; i++) {
                if (mass1[i] == 1) {
                    mass1[i] = 0;
                } else {
                    mass1[i] = 1;
                }
                System.out.print(mass1[i] + " ");

            }System.out.println();
        }

	/* Задать пустой целочисленный массив размером 8. 
	С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
    public static void secondWork () {
        int[] mass2 = new int[8];
        mass2[0] = 0;
        for (int i = 0; i < mass2.length; i++) {
            System.out.print(i * 3 + " ");
        }System.out.println();

    }

	/*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] 
	пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
    public static void thirdWork () {
        int[] mass3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mass3.length; i++) {
            if (mass3[i] <= 6) {
                mass3[i] *= 2;
            } System.out.print(mass3[i] + " ");
        } System.out.println();
    }
	
	/*Создать квадратный двумерный целочисленный массив (количество строк и столбцов
	одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
	(можно только одну из диагоналей, если обе сложно). Определить элементы одной из
	диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
	[1][1], [2][2], …, [n][n];*/
    public static void fourthWork () {
        int[][] mass4 = new int[5][5];
        for (int i = 0; i < mass4.length; i++) {
            for ( int j = 0; j < mass4.length; j++) {
                System.out.print(((mass4[i] == mass4[j]) || (j == ((mass4.length - 1) - i))) ? 1: 0);
            }
            System.out.println();
        }
    }

	/*Задать одномерный массив и найти в нем минимальный и максимальный элементы;*/
    public static void fifthWork () {
        int min;
        int max;
        int[] mass5 = new int[10];
        min = max = mass5[0]; 
        for (int i = 0; i < mass5.length; i++) {
            mass5[i] = (int)(Math.random() * 10);
            System.out.print(mass5[i] + " ");
            if (mass5[i] < min) min = mass5[i];
            if (mass5[i] > max) max = mass5[i];
        }
        System.out.println();
        System.out.println("min: " + min + " max: " + max);

    }






}
