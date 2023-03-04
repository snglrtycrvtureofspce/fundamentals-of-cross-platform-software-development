package Core;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    private static final int BUFFER_SIZE = 5;
    private static LinkedList<Integer> buffer = new LinkedList<>();
    private static Random random = new Random();
    public static final Random r = new Random(); // random
    public static final Scanner in = new Scanner(System.in); // scanner
    public static void main(String[] args) {
        out.print("Введите номер задания: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> {
                Thread thr = new Thread(new Runnable() {
                    public void run() {
                        out.println("Hello World!");
                    }
                });
                out.println(thr.getState());

                thr.start();
                out.println(thr.getState());

                thr.interrupt();
                try {
                    thr.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println(thr.getState());
                break;
            }
            case 2 -> {
                Thread thr1 = new Thread(new Runnable()
                {
                    public void run() {
                        //System.out.println("T-090 flow");
                    }

                });

                Thread thr2 = new Thread(new Runnable()
                {
                    public void run() {
                      //  System.out.println("T-091 flow");
                    }

                });

                thr1.start();
                thr2.start();
                thr1.setName("T-993");
                thr2.setName("T-091");
                System.out.println(thr1.getName());
                System.out.println(thr2.getName());
                break;
            }
            case 3 -> {
                ArrayList<Integer> list = new ArrayList<Integer>();
                Random rand = new Random();

                Thread producer = new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            if (list.size() != 5) {
                                int t=rand.nextInt(10);

                                list.add(t);
                                System.out.println(i + "Добавление			" + t);
                               // System.out.println();
                            } else {
                                System.out.println(i + "Поток полон			" );
                               // System.out.println();

                                try {
                                    Thread.sleep(700);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }
                });

                Thread customer = new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 20; i++) {

                            if (list.size() != 0) {
                                {
                                    int c= list.indexOf(0);
                                    System.out.println(i + "Удаление			" + c);
                                   list.remove(0);

                                    System.out.println();
                                }
                            } else {
                                System.out.println(i + "Поток пуст			" );
                                //System.out.println();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }

                    }
                });
                producer.start();
                customer.start();

                System.out.println("Потоки запущены\n");
            }
            case 4 ->
            {
                Thread producer = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            synchronized (buffer) {
                                while (buffer.size() == BUFFER_SIZE) { // буфер полный, ждем пока потребитель заберет данные
                                    try {
                                        buffer.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                int t = random.nextInt(10);
                                buffer.add(t);
                                System.out.println("Добавление " + t);
                                buffer.notify(); // будим потребителя
                            }
                        }
                    }
                });

                Thread consumer = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            synchronized (buffer) {
                                while (buffer.isEmpty()) { // буфер пуст, ждем пока производитель добавит данные
                                    try {
                                        buffer.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                int t = buffer.removeFirst();
                                System.out.println("Удаление " + t);
                                buffer.notify(); // будим производителя
                            }
                        }
                    }
                });

                producer.start();
                consumer.start();
                break;
            }
            default -> out.println("Exit...");
        }
    }
}