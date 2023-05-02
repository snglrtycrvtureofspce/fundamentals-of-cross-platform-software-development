package task3;

import java.util.ArrayList;
import java.util.List;

public class PostOffice implements Publisher {
    private final List<Subscriber> subscribers;

    public PostOffice() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addObserver(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeObserver(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String publication) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(publication);
        }
    }

    public List<Subscriber> getSubscribers() {
        return this.subscribers;
    }

    public void receivePublication(String publication) {
        System.out.println("Почтовое отделение: Получило новую публикацию - " + publication);
        notifySubscribers(publication);
    }
}
