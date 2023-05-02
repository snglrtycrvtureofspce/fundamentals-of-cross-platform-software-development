package task3;

public class Tablet implements Subscriber {
    private final String brand;

    public Tablet(String brand) {
        this.brand = brand;
    }

    @Override
    public void update(String publication) {
        System.out.println("Планшет (" + brand + "): Получил новую публикацию - " + publication);
    }
}