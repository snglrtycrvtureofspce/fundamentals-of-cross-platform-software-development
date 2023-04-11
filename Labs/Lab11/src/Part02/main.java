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
        Report.generateReport(employees,"ru","RU");
        Report.generateReport(employees,"en","US");
    }
}
