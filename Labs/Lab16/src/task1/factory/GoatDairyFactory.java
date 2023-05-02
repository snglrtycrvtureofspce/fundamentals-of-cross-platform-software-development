package task1.factory;

import task1.goat.GoatCheese;
import task1.goat.GoatMilk;
import task1.goat.GoatSourCream;
import task1.product.Cheese;
import task1.product.Milk;
import task1.product.SourCream;

public class GoatDairyFactory extends DairyFactory {
    @Override
    public Cheese createCheese() {
        return new GoatCheese();
    }

    @Override
    public Milk createMilk() {
        return new GoatMilk();
    }

    @Override
    public SourCream createSourCream() {
        return new GoatSourCream();
    }
}
