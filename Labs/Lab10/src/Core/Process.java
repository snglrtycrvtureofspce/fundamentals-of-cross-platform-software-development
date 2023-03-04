package Core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Process extends Thread {
    public static void Doing ()
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Fork[] forks = new Fork[5];

        for (int i = 0; i < 5; i++)forks[i] = new Fork();

        Filos[] filos = new Filos[5];

        for (int i = 0; i < 5; i++)
        {
            filos[i] = new Filos(i+1, forks[i], forks[(i + 1) % 5]);
            executorService.submit(filos[i]);
        }
        try { sleep(10000); }
        catch(Exception e) {}
        for (int i = 0; i < 5; i++)
            System.out.println("Философ " + i + " кушает: " + filos[i].countOfEat + " раз");
        System.exit(1);
    }
}
