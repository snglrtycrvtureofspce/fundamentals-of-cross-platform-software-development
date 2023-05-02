package task3;

public class Phone implements Subscriber {
    private String brand;

    public Phone(String brand) {
        this.brand = brand;
    }

    @Override
    public void update(String publication) {
        System.out.println("Телефон (" + brand + "): Получил новую публикацию - " + publication);
    }

    @Override
    public String toString() {
        return "Телефон " + brand + " Получил!!!! публикацию";
    }
}
