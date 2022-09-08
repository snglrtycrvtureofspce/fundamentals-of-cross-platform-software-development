package Core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> {
                double x = 4 / 2 + Math.pow(3, 2);
                System.out.println("Ответ: " + x);
            }
            case 2 -> {
                int even = 0;
                int[] array;
                array = new int[20];
                for (int i = 0; i < array.length; i++) {
                    array[i] = ((int) (Math.random() * 31) - 16);
                    System.out.println(array[i]);
                }
                System.out.println("____________________________________");
                for (int i = 0; i < array.length; i++) {
                    if ((i % 2 == 0) && (array[i] % 2 == 0)) {
                        even++;
                    }
                }
                System.out.println("Чётных чисел на чётных местах: " + even);
            }
            case 3 -> {
                int[][] twoDimArray = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        twoDimArray[i][j] = ((int) (Math.random() * 31) - 16);
                    }
                }
                int sum = 0;
                System.out.print("Введите строку начального элемента массива: ");
                int first = in.nextInt();
                System.out.print("Введите столбец начального элемента массива: ");
                int second = in.nextInt();
                System.out.print("Введите строку последнего элемента массива: ");
                int third = in.nextInt();
                System.out.print("Введите столбец последнего элемента массива: ");
                int fourth = in.nextInt();
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        
                    }
                }
            } default -> System.out.println("Exit...");
        }
    }
}
