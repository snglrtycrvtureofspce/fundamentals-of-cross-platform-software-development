package Core;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import static java.lang.System.out;
import java.util.stream.IntStream;

public class Main {
    public static final Random random = new Random();
    public static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> { // task 1
                PribabilNums pribabilityGen = new PribabilNums(new int[]{1,2,3},new int[]{1,2,10});
               // IntStream.generate(pribabilityGen::getNextVal).limit(33).forEach(out::println);
                for (int i = 0; i< 33; i++) {
                    System.out.println(pribabilityGen.getNextVal());
                }
            }
            case 2 -> {
                Person Aleksandr = new Person();
                Aleksandr.display_into();
                out.println(Aleksandr.bd());
            } default -> out.println("Exit...");
        }

    }
}
class PribabilNums { // task 1
    public static final Random random = new Random();
    public final int[] vals;
    public final int[] probabilVals;
    public final int rangUnit;

    PribabilNums(int[] vals, int[] probabilVals) {
        this.vals = vals;
        this.probabilVals = probabilVals;
        this.rangUnit = getRangUnit();
    }

    private int getRangUnit(){
        return Integer.MAX_VALUE / Arrays.stream(probabilVals).max().getAsInt();
        // MAX_VALUE	Максимальное значение, которое вмещает в себя тип int
        // MIN_VALUE	Минимальное значение, которое вмещает в себя тип int
        // stream       Он возвращает последовательный поток с элементами массива, переданного в качестве параметра,
        //              в качестве его источника.
    }

    int getNextVal() {
        int rndNu = Math.abs(PribabilNums.random.nextInt());
        for (int i = 0; i < probabilVals.length; i++) {
            if (rndNu <= rangUnit * probabilVals[i]) {
                return vals[i];
            };
        }
        return -1;
    }
}
class Person { // task 2
    Person(){
        name = "Александр";
        age = 17;
        weight = 54.5;
        height = 182;
    }
    String name;
    int age;
    double weight, height;
    void walk(){
        out.println("Бегу!");
    }
    void display_into () {
        out.println("Имя: " + name + "\nВозраст: " + age + "\nРост/Вес: " + height + "/" + weight );
    }
    int bd(){
        return 2022 - age;
    }
}
