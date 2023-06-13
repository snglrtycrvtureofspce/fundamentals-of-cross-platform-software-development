import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static final Random rnd = new Random(); // random
    public static final Scanner in = new Scanner(System.in); // scanner
    public static int[] Arr(int[] inputArray, int k) {
        List<Integer> resultList = new ArrayList<>();

        for (int num : inputArray) {
            if (num % 10 == k) {
                resultList.add(num);
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
    public static void main(String[] args) {
        // Java. Создайте класс с методом Arr, в котором дан массив, состоящий из n натуральных чисел.
        // Образовать новый массив, элементами которого будут элементы исхожного, оканчивающиеся на цифру k.
        int[] inputArray = new int[10];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = rnd.nextInt(10, 100);
            out.println(inputArray[i]);
        }
        out.print("Введите k: ");
        int k = in.nextInt();

        int[] resultArray = Arr(inputArray, k);

        out.println("Массив:");
        for (int num : resultArray) {
            out.println(num);
        }
    }
}