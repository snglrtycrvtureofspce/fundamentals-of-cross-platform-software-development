package task3.main;
import task3.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем почтовое отделение и устройства разных марок
        PostOffice postOffice = new PostOffice();

        Phone hpPhone = new Phone("HP");
        Phone applePhone = new Phone("Apple");
        Tablet samsungTablet = new Tablet("Samsung");
        Tablet acerTablet = new Tablet("Acer");
        Computer dellComputer = new Computer("Dell");
        Computer asusComputer = new Computer("Asus");

        // Подписываем каждое устройство на обновления в Почтовом отделении
        postOffice.addObserver(hpPhone);
        postOffice.addObserver(applePhone);
        postOffice.addObserver(samsungTablet);
        postOffice.addObserver(acerTablet);
        postOffice.addObserver(dellComputer);
        postOffice.addObserver(asusComputer);

        // Поступает новая публикация в почтовое отделение
        postOffice.receivePublication("Публикация");

        // Пользователь выбирает категорию устройств и получает список доступных устройств
        List<Subscriber> phones = getDevicesByCategory(postOffice, "Phone");
        List<Subscriber> tablets = getDevicesByCategory(postOffice, "Tablet");
        List<Subscriber> computers = getDevicesByCategory(postOffice, "Computer");
       // System.out.println(phones.toString());
        // Пользователь может купить любое из устройств из списка
        Subscriber selectedDevice = phones.get(0);
        System.out.println("Выбранные устройства: " + selectedDevice);
    }

    private static List<Subscriber> getDevicesByCategory(PostOffice postOffice, String category) {
        List<Subscriber> devices = new ArrayList<>();

        for (Subscriber subscriber : postOffice.getSubscribers()) {
            if (subscriber.getClass().getSimpleName().equals(category)) {
                devices.add(subscriber);
            }
        }

        System.out.println("Доступно " + category + "s: " + devices);

        return devices;
    }
}