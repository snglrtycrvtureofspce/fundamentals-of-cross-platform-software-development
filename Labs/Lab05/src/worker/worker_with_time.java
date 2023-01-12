package worker;

public class worker_with_time extends worker {
    private double _ratePerHour;

    public worker_with_time(String name, int id, double ratePerHour)
    {
        super(name, id);
        this._ratePerHour = ratePerHour;
    }

    @Override
    public double getAverageSalary() {
        return 20.8 * 8 * this._ratePerHour;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getId() {
        return super.getId();
    }
}
