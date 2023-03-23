package Part02;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Employee("Aleksandr Zenevich",250440.08),
                new Employee("Ivan Taraskevich",30122050.12)
        };
/*        Scanner x = new Scanner(System.in);
        System.out.println("Введите язык");
        String language = x.nextLine();
        System.out.println("Введите страну");
        String country = x.nextLine();*/
        Report.generateReport(employees,"ru","RU");
        Report.generateReport(employees,"en","US");

    }
}
