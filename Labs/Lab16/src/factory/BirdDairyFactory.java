package factory;

import bird.BirdCheese;
import bird.BirdMilk;
import bird.BirdSourCream;
import product.Cheese;
import product.Milk;
import product.SourCream;

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
