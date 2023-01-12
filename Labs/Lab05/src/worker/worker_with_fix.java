package worker;

public class worker_with_fix extends worker{
    private double _fixedPayment;

    public worker_with_fix(String name, int id, double fixedPayment)
    {
        super(name, id);
        this._fixedPayment = fixedPayment;
    }
    @Override
    public double getAverageSalary() {
        return _fixedPayment;
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
