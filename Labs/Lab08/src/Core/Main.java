package Core;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static final Random r = new Random(); // random
    public static final Scanner in = new Scanner(System.in); // scanner
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p){
            case 1 -> {
                try (FileReader reader = new FileReader("C:\\Users\\snglrtycrvtureofspce\\Documents\\snglrtycrvtureofspce\\GitHub\\fundamentals-of-cross-platform-software-development\\Labs\\Lab08\\src\\Core\\info.txt"))
                {
                    int c;
                    while ((c = reader.read()) != -1)
                    {
                        out.print((char) c);
                    }
                }
                catch (IOException e)
                {
                    out.println(e.getMessage());
                }
            }
            case 2 -> {
                try (FileWriter writer = new FileWriter("C:\\Users\\snglrtycrvtureofspce\\Documents\\snglrtycrvtureofspce\\GitHub\\fundamentals-of-cross-platform-software-development\\Labs\\Lab08\\src\\Core\\test.txt", false))
                {
                    writer.write("");
                    out.print("Введите строку: ");
                    String text = bufferedReader.readLine();
                    writer.write(text);
                    writer.flush();

                }
                catch (IOException e)
                {
                    out.println(e.getMessage());
                }
            }
            default -> {
                out.println("Exit...");
            }
        }
    }
}
