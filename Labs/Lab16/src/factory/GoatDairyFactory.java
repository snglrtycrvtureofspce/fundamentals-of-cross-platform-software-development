package factory;

import goat.GoatCheese;
import goat.GoatMilk;
import goat.GoatSourCream;
import product.Cheese;
import product.Milk;
import product.SourCream;

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
