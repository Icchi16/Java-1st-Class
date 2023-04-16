package Session2.demo;

import java.util.Arrays;


public class Geometric {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(8,4);
        System.out.println("long -------> " + rectangle.getLonger());
        System.out.println("short -------> " + rectangle.getShorter());
        System.out.println(rectangle);
        rectangle.getArea();
        Rectangle rectangle1 = new Rectangle(6,2);
        rectangle1.getArea();
        int arr[] = {1,2,5,4,3};
        int number = 10;
        botArray(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void themArray (int[] array, int number) {
        int arr1[] = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            arr1[i] = array[i];
        }
        arr1[arr1.length - 1] = number;
        System.out.println(Arrays.toString(arr1));
    }

    public static void botArray (int[] array) {
        int arr1[] = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            arr1[i] = array[i];
        }
        System.out.println(Arrays.toString(arr1));
    }
}
