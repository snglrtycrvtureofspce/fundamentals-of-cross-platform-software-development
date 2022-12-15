package Core;

public class Person {
    private String fullName;
    private int age;

    public Person() {
        this("", 0);
    }

    public Person(String fullName) {
        this(fullName, 0);
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void info() {
        System.out.print("Привет! Моё имя " + this.fullName + "\nМне " + this.age + " лет.");
    }
}
