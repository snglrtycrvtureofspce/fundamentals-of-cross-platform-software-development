package Core;

public class ReportZD2 {
    public static void doing()
    {
        Employee[] arr = new Employee[2];
        Employee emp1 = new Employee("bebra", 150);
        Employee emp2 = new Employee("huggy", 200.222);
        arr[0] = emp1;
        arr[1] = emp2;
        Report.generateReport(arr);
        System.out.println();
    }
}
