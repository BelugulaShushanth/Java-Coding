package designPatterns.creational.abstractFactory.processors;

public class StripePaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processed "+amount+" using STRIPE US");
    }
}
