package Core;

public class Fork {
    private Boolean taken = false;

    public synchronized void take() throws InterruptedException
    {
        while (taken) wait();
        taken = true;
    }

    public synchronized void drop()
    {
        taken = false;
        notifyAll();
    }

}
