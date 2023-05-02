package task1.factory;

import task1.cow.CowCheese;
import task1.cow.CowMilk;
import task1.cow.CowSourCream;
import task1.product.Cheese;
import task1.product.Milk;
import task1.product.SourCream;

public class CowDairyFactory extends DairyFactory {
    @Override
    public Cheese createCheese() {
        return new CowCheese();
    }

    @Override
    public Milk createMilk() {
        return new CowMilk();
    }

    @Override
    public SourCream createSourCream() {
        return new CowSourCream();
    }
}
