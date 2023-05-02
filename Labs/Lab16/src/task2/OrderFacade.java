package task2;

public class OrderFacade {
    private final Order order;
    private final Payment payment;
    private final Shipping shipping;

    public OrderFacade() {
        this.order = new Order();
        this.payment = new Payment();
        this.shipping = new Shipping();
    }

    public void placeOrder(String itemName, int quantity, String shippingAddress, String paymentMethod) {
        order.addItem(itemName, quantity);
        payment.pay(paymentMethod);
        shipping.ship(shippingAddress);
        printOrderDetails(itemName, quantity, shippingAddress, paymentMethod);
    }

    private void printOrderDetails(String itemName, int quantity, String shippingAddress, String paymentMethod) {
        System.out.println("Продукт " + itemName + " был добавлен в корзину товаров.");
        System.out.println("Платёж прошёл успешно с " + paymentMethod + ".");
        System.out.println("Ваш заказ был доставлен на " + shippingAddress + ".\n");
    }
}