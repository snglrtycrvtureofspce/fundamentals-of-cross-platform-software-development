package Core;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> {
                double x = 4/2 + Math.pow(3, 2);
                System.out.println("Ответ: " + x);
            }
            case 2 -> {
                int even = 0; // кол-во чётных
                int[] array;
                array = new int[20];
                for (int i = 0; i < array.length; i++) {
                    array[i] = r.nextInt(100);
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
                int[][] twoArray = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        twoArray[i][j] = r.nextInt(100);
                    }
                }
                int sum = 0; // сумма
                int index = 0;
                System.out.print("Введите первый индекс: ");
                int first = in.nextInt();
                System.out.print("Введите второй индекс: ");
                int second = in.nextInt();
                for (int i = 0; i < twoArray.length; i++) {
                    for (int j = 0; j < twoArray[i].length; j++) {
                        if (index >= first &&  index < second) {
                            sum += twoArray[i][j];
                            System.out.print(twoArray[i][j] + " ");
                        }
                        index++;
                    }
                }
                System.out.println();
                System.out.println("sum: " + sum);

            }
            case 4 -> {
                System.out.print("Введите число: ");
                int num = in.nextInt(); // число
                System.out.print("Введите число: ");
                int n = in.nextInt(); // делитель
                if (num % n == 0){
                    System.out.println("Число " + num + " делится на " + n + " !");
                    System.out.println("Ответ: " + num/n);
                }
                else {
                    System.out.println("Число " + num + " не делится на " + n + " !");
                }
            }
            case 5 -> {
                System.out.print("Введите цифру: ");
                int p_1 = in.nextInt();
                switch (p_1) {
                    case 1 -> {
                        System.out.print("Один");
                    }
                    case 2 -> {
                        System.out.print("Два");
                    }
                    case 3 -> {
                        System.out.print("Три");
                    }
                    case 4 -> {
                        System.out.print("Четыре");
                    }
                    case 5 -> {
                        System.out.print("Пять");
                    }
                    case 6 -> {
                        System.out.print("Шесть");
                    }
                    case 7 -> {
                        System.out.print("Семь");
                    }
                    case 8 -> {
                        System.out.print("Восемь");
                    }
                    case 9 -> {
                        System.out.print("Девять");
                    }
                    default -> System.out.println("Exit...");
                }
            }
            case 6 -> {
                System.out.print("Введите день недели: ");
                int p_2 = in.nextInt();
                System.out.print(Month.dayOFWeek(p_2));
            }
            case 7 -> {

            }
            case 8 -> {

            }
            case 9 -> {

            } default -> System.out.println("Exit...");
        }
    }
}
class Month {
    static String dayOFWeek(int week) {
        return switch (week) {
            case 1 -> "Понедельник";
            case 2 -> "Вторник";
            case 3 -> "Среда";
            case 4 -> "Четверг";
            case 5 -> "Пятница";
            case 6 -> "Суббота";
            case 7 -> "Воскресенье";
            default -> "Exit...";
        };
    }
}