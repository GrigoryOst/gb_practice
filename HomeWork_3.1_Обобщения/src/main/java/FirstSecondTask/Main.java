package FirstSecondTask;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        First();
        System.out.println();
        Second();
    }

    /* Написать метод, который меняет
    два элемента массива местами.
    (массив может быть любого ссылочного типа);*/

    public static void First(){
        String[] array = {"Apple", "Orange", "Banana", "Grape", "Peach", "Pear"};
        System.out.print("First task: " + Arrays.toString(array) + " ---> ");

        swapIndex(array,3, 0);
        System.out.println(Arrays.toString(array));
    }

    private static <T> void swapIndex (T[] arr, int index1, int index2) {
        T t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }

    /*Написать метод, который преобразует массив в ArrayList;*/

    public static void Second() {
        String[] array = {"Apple", "Orange", "Banana", "Grape", "Peach", "Pear"};
        List<String> list = convertArray(array);
        System.out.println("Second task: " + list + "; Class is: " + list.getClass());
    }

    private static <E> List<E> convertArray (E[] arr) {
        return Arrays.asList(arr);
    }




}
