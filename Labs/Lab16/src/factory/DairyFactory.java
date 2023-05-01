package factory;

import product.Cheese;
import product.Milk;
import product.SourCream;

public abstract class DairyFactory {
    public abstract Cheese createCheese();
    public abstract Milk createMilk();
    public abstract SourCream createSourCream();
}