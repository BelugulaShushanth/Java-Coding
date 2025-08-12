package designPatterns.behavioural.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment("Jhon doe"));
        cart.checkout(200);

        cart.setPaymentStrategy(new PayPalPayment("jhon123@gmail.com"));
        cart.checkout(500);
    }
}
