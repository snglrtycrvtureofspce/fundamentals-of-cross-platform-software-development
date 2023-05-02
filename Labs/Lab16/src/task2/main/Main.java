package task2.main;

import task2.OrderFacade;

public class Main {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("Первый продукт", 2, "220102 Казимировская 44, Минск", "Наличные");
        orderFacade.placeOrder("Второй продукт", 2, "124312 Пушкинская 44, Минск", "Карта");
    }
}
