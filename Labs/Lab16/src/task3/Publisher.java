package task3;

public interface Publisher {
    void addObserver(Subscriber subscriber);
    void removeObserver(Subscriber subscriber);
    void notifySubscribers(String publication);
}