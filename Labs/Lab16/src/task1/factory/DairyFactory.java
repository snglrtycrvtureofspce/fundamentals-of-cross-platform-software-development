package task1.factory;

import task1.product.Cheese;
import task1.product.Milk;
import task1.product.SourCream;

public abstract class DairyFactory {
    public abstract Cheese createCheese();
    public abstract Milk createMilk();
    public abstract SourCream createSourCream();
}