package Core;

public class Filos implements Runnable {
    private Fork left;
    private Fork right;
    public int countOfEat;
    private int id;

    public Filos(int id, Fork left, Fork right)
    {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    private void thinking()
    {
        try { Thread.sleep(1000); }
        catch(Exception e){}
    }
    private void eating()
    {
        ++this.countOfEat;
        try{ Thread.sleep(1000); }
        catch(Exception e){}
    }
    @Override
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                System.out.println(this + " думает");
                thinking();

                right.take();
                System.out.println(this + " взял правую вилку");

                left.take();
                System.out.println(this + " взял левую вилку");
                eating();
                System.out.println(this + " кушает");

                right.drop();
                System.out.println(this + " кинул правую вилку");
                left.drop();
                System.out.println(this + " кинул левую вилку");
            }
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    public String toString() { return "Философ " + id; }
}
