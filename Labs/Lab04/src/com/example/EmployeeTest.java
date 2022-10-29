package com.example;

import com.example.domain.*;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

public class EmployeeTest {
    public static final Random random = new Random();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        out.print("Введите задание: ");
        int p = in.nextInt();
        switch (p) {
            case 1 -> { // task 1
                Engineer eng = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);
                Manager mgr = new Manager(207, "Barbara Johnson", "054-12- 2367", 109_501.36, "US Marketing");
                Admin adm = new Admin(304, "Bill Munroe", "108-23-2367", 75_002.34);
                Director dir = new Director(12, "Susan Wheeler", "099-45- 2340", 120_567.36, "Global Marketing", 1_000_000.00);
                printEmployee(eng);
                printEmployee(mgr);
                printEmployee(adm);
                printEmployee(dir);
            }
            case 2 -> { // 2
                Animal a;
                Spider s = new Spider();
                s.eat();
                s.walk();
                Cat c = new Cat("Tom");
                c.eat();
                c.walk();
                c.play();
                a = new Cat();
                a.eat();
                a.walk();
                Pet p;
                p = new Cat();
                p.setName("Mr. Whiskers");
                p.play();
                Fish f = new Fish();
                f.setName("Guppy");
                f.eat();
                f.walk();
                f.play();
                a = new Fish();
                a.eat();;
                a.walk();
            } default -> out.println("Exit...");
        }
    }
    private static void printEmployee(Employee emp) {
        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Soc Sec # " + emp.getSsn());
        System.out.println("Employee salary: " + emp.getSalary());
    }
}