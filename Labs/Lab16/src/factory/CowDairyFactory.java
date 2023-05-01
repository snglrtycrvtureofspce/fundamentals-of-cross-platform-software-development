package factory;

import cow.CowCheese;
import cow.CowMilk;
import cow.CowSourCream;
import product.Cheese;
import product.Milk;
import product.SourCream;

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
