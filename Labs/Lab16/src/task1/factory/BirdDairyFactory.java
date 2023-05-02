package task1.factory;

import task1.bird.BirdCheese;
import task1.bird.BirdMilk;
import task1.bird.BirdSourCream;
import task1.product.Cheese;
import task1.product.Milk;
import task1.product.SourCream;

public class BirdDairyFactory extends DairyFactory {
    @Override
    public Cheese createCheese() {
        return new BirdCheese();
    }

    @Override
    public Milk createMilk() {
        return new BirdMilk();
    }

    @Override
    public SourCream createSourCream() {
        return new BirdSourCream();
    }
}
