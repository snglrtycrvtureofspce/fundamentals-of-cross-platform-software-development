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
                try
                {
                    FileReader reader = new FileReader("C:\\Users\\snglrtycrvtureofspce\\Documents\\snglrtycrvtureofspce\\GitHub\\fundamentals-of-cross-platform-software-development\\Labs\\Lab08\\src\\Core\\info.txt");
                    int c;
                    while ((c = reader.read()) != -1) // read
                    {
                        out.print((char) c);
                    }
                    reader.close();
                }
                catch (IOException e)
                {
                    out.println(e.getMessage());
                }
                catch (Exception e)
                {
                    out.println(e.getMessage());
                }
            }
            case 2 -> {
                try
                {
                    FileWriter writer = new FileWriter("C:\\Users\\snglrtycrvtureofspce\\Documents\\snglrtycrvtureofspce\\GitHub\\fundamentals-of-cross-platform-software-development\\Labs\\Lab08\\src\\Core\\test.txt", false);
                    writer.write(""); // clear
                    out.print("Введите числа: ");
                    String text = bufferedReader.readLine();
                    writer.write(text);
                    writer.flush(); //
                    FileReader reader = new FileReader("C:\\Users\\snglrtycrvtureofspce\\Documents\\snglrtycrvtureofspce\\GitHub\\fundamentals-of-cross-platform-software-development\\Labs\\Lab08\\src\\Core\\test.txt");
                    int c;
                    int count = 0;
                    double avg = 0.0;
                    out.print("Числа: ");
                    while ((c = reader.read()) != -1) // read/average
                    {
                        out.print((char) c);
                        int a = Character.getNumericValue(c); // toInt
                        avg += a;
                        count++;
                    }
                    out.println();
                    double result = avg / count;
                    out.println("Среднее значение: " + result);
                    writer.close();
                    reader.close();
                }
                catch (IOException e)
                {
                    out.println(e.getMessage());
                }
                catch (Exception e)
                {
                    out.println(e.getMessage());
                }
            }
            case 3 -> {
                int digit;
                try (FileWriter writer = new FileWriter("f.txt", false))
                {
                    for (int i=0; i<10 ;i++)
                    {
                        digit= (int) (( Math.random() * (9) ) + 1);
                        writer.append(digit+" ");
                    }
                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                try(FileWriter writer1 = new FileWriter("g.txt", false))
                {
                    try(FileWriter writer2 = new FileWriter("h.txt", false))
                    {
                        try(FileReader reader = new FileReader("f.txt"))
                        {
                            int c;
                            String str = "";
                            while((c = reader.read()) != -1){

                                if(Character.isDigit((char)c))
                                {
                                    str += (char)c;
                                }
                                else
                                {
                                    System.out.print(str + " ");
                                    digit=Integer.parseInt(str);
                                    if(digit % 2 ==0)
                                        writer1.append(digit + " ");
                                    else
                                        writer2.append(digit + " ");
                                    str = "";
                                }

                            }
                        }
                        catch(IOException ex){

                            System.out.println(ex.getMessage());
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case 4 -> {
                try
                {
                    int z;
                    FileWriter writer = new FileWriter("C:\\Users\\snglrtycrvtureofspce\\Documents\\snglrtycrvtureofspce\\GitHub\\fundamentals-of-cross-platform-software-development\\Labs\\Lab08\\src\\Core\\test.txt", false);
                    writer.write(""); // clear
                    out.print("Введите значения температуры через пробел: ");
                    String text = bufferedReader.readLine();
                    writer.write(text);
                    writer.flush(); //
                    FileReader reader = new FileReader("C:\\Users\\snglrtycrvtureofspce\\Documents\\snglrtycrvtureofspce\\GitHub\\fundamentals-of-cross-platform-software-development\\Labs\\Lab08\\src\\Core\\test.txt");
                    int c;
                    int count = 0;
                    double avg = 0.0;
                    out.print("Числа: ");
                    while ((c = reader.read()) != -1) // read/average
                    {
                        out.print((char) c);
                        int a = Character.getNumericValue(c); // toInt
                        avg += a;
                        count++;
                    }
                    out.println();
                    double result = avg / count;
                    out.println("Среднее значение температуры: " + result);
                    writer.close();
                    reader.close();
                }
                catch (IOException e)
                {
                    out.println(e.getMessage());
                }
                catch (Exception e)
                {
                    out.println(e.getMessage());
                }
            }
            case 5 -> {
                Scanner scanner = new Scanner(System.in);
                int digit;
                int count = 0;
                try(FileWriter writer = new FileWriter("f.txt", false))
                {
                    for(int i=0;i<10;i++)
                    {
                        System.out.print("Введите число: ");
                        digit = scanner.nextInt();
                        writer.append(digit + " ");
                    }
                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }

                try(FileReader reader = new FileReader("f.txt"))
                {
                    int c;
                    String str = "";
                    while((c = reader.read()) != -1){

                        if(Character.isDigit((char)c) || (char)c == '-')
                        {
                            str += (char)c;
                        }
                        else
                        {
                            System.out.print(str + " ");
                            digit=Integer.parseInt(str);
                            if(digit > 0)
                                count++;
                            str = "";
                        }

                    }
                    System.out.println("Количество положительных значений: " + count);
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
            }
            default -> {
                out.println("Exit...");
            }
        }
    }
}
