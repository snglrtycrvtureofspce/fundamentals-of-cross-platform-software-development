package Core;

import java.util.Scanner;
import java.util.Random;

import static java.lang.System.out;

public class Main {
    public static final Random r = new Random(); // random
    public static final Scanner in = new Scanner(System.in); // scanner
    public static void main(String[] args) {
        out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> { // task 1
                double x = 4.0 / 2.0 + Math.pow(3, 2);
                out.println("Ответ: " + x);
            }
            case 2 -> { // task 2
                int even = 0; // amount of even
                int[] array;
                array = new int[20];
                for (int i = 0; i < array.length; i++) {
                    array[i] = r.nextInt(100);
                    out.println(array[i]);
                }
                out.println("____________________________________");
                for (int i = 0; i < array.length; i++) {
                    if ((i % 2 == 0) && (array[i] % 2 == 0)) {
                        even++;
                    }
                }
                out.println("Чётных чисел на чётных местах: " + even);
            }
            case 3 -> { // task 3
                int[][] twoArray = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        twoArray[i][j] = r.nextInt(100);
                        out.print(twoArray[i][j] + "\t");
                    }
                    out.println();
                }
                int sum = 0; // сумма
                int index = 0;
                out.print("Введите первый индекс: ");
                int first = in.nextInt();
                out.print("Введите второй индекс: ");
                int second = in.nextInt();
                for (int i = 0; i < twoArray.length; i++) {
                    for (int j = 0; j < twoArray[i].length; j++) {
                        if (index >= first && index < second) {
                            sum += twoArray[i][j];
                            out.print(twoArray[i][j] + " ");
                        }
                        index++;
                    }
                }
                out.println();
                out.println("sum: " + sum);
            }
            case 4 -> { // task 4.1
                out.print("Введите число: ");
                int num = in.nextInt(); // number
                out.print("Введите число: ");
                int n = in.nextInt(); // divider
                if (num % n == 0) {
                    out.println("Число " + num + " делится на " + n + " !");
                    out.println("Ответ: " + num/n);
                }
                else {
                    out.println("Число " + num + " не делится на " + n + " !");
                }
            }
            case 5 -> { // task 4.2
                out.print("Введите цифру: ");
                int p_1 = in.nextInt();
                switch (p_1) {
                    case 1 -> out.print("Один");
                    case 2 -> out.print("Два");
                    case 3 -> out.print("Три");
                    case 4 -> out.print("Четыре");
                    case 5 -> out.print("Пять");
                    case 6 -> out.print("Шесть");
                    case 7 -> out.print("Семь");
                    case 8 -> out.print("Восемь");
                    case 9 -> out.print("Девять");
                    default -> out.println("Exit...");
                }
            }
            case 6 -> { // task 4.3
                out.print("Введите день недели: ");
                int p_2 = in.nextInt();
                out.print(Month.dayOFWeek(p_2));
            }
            case 7 -> { // task 4.4
                out.print("Введите столицу: ");
                String p_3 = in.next();
                switch (p_3) {
                    case "Беларусь" -> out.println("Минск");
                    case "Россия" -> out.println("Москва");
                    case "США" -> out.println("Вашингтон");
                    case "Литва" -> out.println("Вильнюс");
                    case "Япония" -> out.println("Токио");
                    default -> out.println("Exit...");
                }
            }
            case 8 -> { // task 4.5
                out.print("Введите n: ");
                int n = in.nextInt();
                out.println("Сумма нечётных чисел: " + sum(n));
            }
            case 9 -> { // task 4.6
                out.print("Введите n: ");
                int n = in.nextInt();
                out.println("Произведение чётных чисел: " + mul(n));
            }
            case 10 -> { // task 4.7
                out.print("Введите свой рост: ");
                double height = in.nextDouble();
                out.print("Введите свой вес: ");
                double weight = in.nextDouble();
                double bmi = bmi_mass(height, weight);
                out.println("Ваш имт: " + bmi);
                if (bmi < 18.49) {
                    out.println("Вам нужно поправится");
                }
                else if (bmi >= 18.5 && bmi <= 24.9) {
                    out.println("У вас нормальная масса тела!");
                }
                else if (bmi >= 25 && bmi <= 29.9) {
                    out.println("Вам нужно похудеть!");
                }
            }
            case 11 -> { // task 5
                for (int i = 0; i < 51; i++) {
                    out.print(i + "\t");
                }
            } default -> out.println("Exit...");
        }
    }
    public static int mul (int N) { // product of all odd numbers from 1 to n
        int mul = 1, temp;
        for (int i = 0; i < N; i++){
            out.print("Введите число " + i + ": ");
            temp = in.nextInt();
            if (temp % 2 == 0) {
                mul *= temp;
            }
        }
        return mul;
    }
    public static int sum (int N) { // sum of all odd numbers from 1 to n
        int sum = 0, temp, unk = 0;
        while (unk < N) {
            out.print("Введите число " + unk + ": ");
            temp = in.nextInt();
            if (temp % 2 !=0) {
                sum += temp;
            }
            unk++;
        }
        return sum;
    }
    public static double bmi_mass (double height, double weight) {
        return Math.round((weight / Math.pow((height / 100), 2)));
    }
}

class Month { // days of the week
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