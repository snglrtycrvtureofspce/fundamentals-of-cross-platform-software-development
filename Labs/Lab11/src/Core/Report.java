package Core;

import java.text.NumberFormat;

public class Report {
    public static void generateReport(Employee[] arr) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        for (Employee emp : arr) {
            System.out.print(emp.fullname + "\t\t" + nf.format(emp.salary) + "\n");
        }
    }
}
