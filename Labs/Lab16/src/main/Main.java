package main;

import javax.swing.*;

import factory.BirdDairyFactory;
import factory.CowDairyFactory;
import factory.DairyFactory;
import factory.GoatDairyFactory;
import product.Cheese;
import product.Milk;
import product.SourCream;

public class Main {
    public static void main(String[] args) {
        DairyFactory dairyFactory;
        Cheese cheese;
        Milk milk;
        SourCream sourCream;

        String dairyType = JOptionPane.showInputDialog("Выберите тип молока: Коровье, Козье или Птичье");

        switch (dairyType.toLowerCase()) {
            case "коровье" -> dairyFactory = new CowDairyFactory();
            case "козье" -> dairyFactory = new GoatDairyFactory();
            case "птичье" -> dairyFactory = new BirdDairyFactory();
            default -> {
                JOptionPane.showMessageDialog(null, "Ошибка: выберите коровье, козье или " +
                        "птичье молоко!");
                return;
            }
        }

        String productType = JOptionPane.showInputDialog("Выберите продукт: Сыр, Молоко или Сметана");

        switch (productType.toLowerCase()) {
            case "сыр" -> {
                cheese = dairyFactory.createCheese();
                cheese.create();
                JOptionPane.showMessageDialog(null, "Создан " + dairyType.toLowerCase() +
                        " " + productType.toLowerCase());
            }
            case "молоко" -> {
                milk = dairyFactory.createMilk();
                milk.create();
                JOptionPane.showMessageDialog(null, "Создано " + dairyType.toLowerCase() +
                        " " + productType.toLowerCase());
            }
            case "сметана" -> {
                sourCream = dairyFactory.createSourCream();
                sourCream.create();
                JOptionPane.showMessageDialog(null, "Создана " + dairyType.toLowerCase() +
                        " " + productType.toLowerCase());
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Ошибка: выберите сыр, молоко или " +
                        "сметану!");
            }
        }
    }
}