package Core;

import java.util.Date;

public class Employee extends Person {
    private double salary;
    private Date salaryDate;

    public Employee(String fullName) {
        super(fullName);
    }

    public Employee(String fullName, double salary) {
        this(fullName);
        this.salary = salary;
    }

    public Employee(String fullName, double salary, Date salaryDate) {
        this(fullName, salary);
        this.salaryDate = salaryDate;
    }

    public String getFullName() {
        return super.getFullName();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }
}
