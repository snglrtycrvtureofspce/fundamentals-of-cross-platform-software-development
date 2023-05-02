package task3;

public class Computer implements Subscriber {
    private final String brand;

    public Computer(String brand) {
        this.brand = brand;
    }

    @Override
    public void update(String publication) {
        System.out.println("Компьютер (" + brand + "): Получил новую публикацию - " + publication);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                '}';
    }
}