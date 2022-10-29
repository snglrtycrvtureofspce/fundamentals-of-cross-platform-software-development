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
                Employee emp = new Employee();
                emp.setEmpId(101);
                emp.setName("Jane Smith");
                emp.setSalary(120_345.27);
                emp.setSsn("012-34-5678");
                System.out.println("Employee ID: " + emp.getEmpId());
                System.out.println("Employee Name: " + emp.getName());
                System.out.println("Employee Soc Sec # " + emp.getSsn());
                System.out.println("Employee salary: " + emp.getSalary());
            }
            case 2 -> { // task 2
                Figure fgr = new Figure("Фигура");
                out.println(fgr.getName());
            }
            case 4 -> { // task 2.1
                Square sqr = new Square("Квадрат",54,32,52,35);
                out.println(sqr.Sum());
            }
            case 5 -> { // task 2.2
                Square_area sqr_ar = new Square_area("Площадь квадрата", 12, 24);
                out.println(sqr_ar.area());
            }
            case 6 -> { // task 2.2
                Cylinder_volume cyl_vo = new Cylinder_volume("Объём цилиндра", 4, 6);
                out.println(cyl_vo.Volume());
            } default -> out.println("Exit...");
        }
    }
}
