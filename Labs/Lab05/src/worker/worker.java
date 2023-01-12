package worker;

import java.util.Collections;
import java.util.Comparator;

public abstract class worker {
    protected String name;
    private int id;

    public worker() {
    }

    public worker(String name, int id) {
        setName(name);
        setId(id);
    }

    public abstract double getAverageSalary();

    public static Comparator<worker> ComparatorName = new Comparator<worker>() {

        public int compare(worker s1, worker s2) {

            String StudentName1 = s1.getName().toUpperCase();
            String StudentName2 = s2.getName().toUpperCase();

            return StudentName1.compareTo(StudentName2);
        }
    };
    public static Comparator<worker> ComparatorAverageSalary = new Comparator<worker>() {

        public int compare(worker s1, worker s2)
        {
            int StudentName1 = (int) s1.getAverageSalary();
            int StudentName2 = (int) s2.getAverageSalary();
            if (StudentName1 == StudentName2)
            {
                String StudentName3 = s1.getName().toUpperCase();
                String StudentName4 = s2.getName().toUpperCase();
                return StudentName3.compareTo(StudentName4);
            }
            return StudentName2 - StudentName1;
        }
    };

    @Override
    public String toString() {
        return "Зарплата: " + getAverageSalary() + "\n" +
                "Имя: " + getName() + "\n" +
                "Id: " + getId() + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
