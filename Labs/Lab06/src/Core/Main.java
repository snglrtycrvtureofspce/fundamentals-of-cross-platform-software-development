package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class Main {
    public static final Random r = new Random(); // random
    public static final Scanner in = new Scanner(System.in); // scanner

    public static void main(String[] args) {
        out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> {
                String a = "Hello, It's Java!";
                out.println("Строка: " + a);
                out.println("Содержит ли подстроку 'Java'? - " + a.contains("Java"));
            }
            case 2 -> {
                String[] words = {"string", "code", "Practice"};
                for (String word : words) {
                    System.out.printf("%s --> \"%s\"%n", word, word.substring(word.length() / 2 - 1, word.length() / 2 + 1));
                }
            }
            case 3 -> {
                Employee[] employees = {
                        new Employee("Зеневич Николай Сергеевич", 6500),
                        new Employee("Зеневич Дарья Олеговна", 7000),
                        new Employee("Зеневич Олег Николаевич", 12150),
                        new Employee("Зеневич Светлана Анатольевна", 10200),
                        new Employee("Зеневич Александр Олегович", 6500),
                };
                Report.generateReport(employees);
            }
            case 5 -> {
                String text = "7887 4554 991000199 24111100142 001010 700011110007 110101010 10101010101 80001118 1111000010101";
                printInfo(Searcher.getAllEntries("\\d+", text));
            }
            default -> out.println("Exit...");
        }
    }

    public class Searcher {
        public static Matcher getMatcher(String regexp, String text) {
            Pattern pattern = Pattern.compile(regexp);
            return pattern.matcher(text);
        }

        public static List<String> getAllEntries(String regexp, String text) {
            List<String> words = new ArrayList<>();
            Matcher m = getMatcher(regexp, text);
            while (m.find()) {
                words.add(text.substring(m.start(), m.end()));
            }
            return words;
        }

        public static boolean isPalindrome(String word) {
            StringBuilder sb = new StringBuilder(word).reverse();
            return word.equals(sb.toString());
        }
    }

    public static void printInfo(List<String> words) {
        System.out.println("Палиндромы встречающиеся в данной строке:");
        String s = "";
        for (String word : words) {
            if (Searcher.isPalindrome(word)) {
                s = !s.equals("") ? String.join(", ", s, word) : word;
            }
        }
        System.out.println(s);
    }
}
