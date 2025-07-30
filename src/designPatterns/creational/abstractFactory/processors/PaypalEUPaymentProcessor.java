package designPatterns.creational.abstractFactory.processors;

public class PaypalEUPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processed "+amount+" using PAYPAL EU");
    }
}
