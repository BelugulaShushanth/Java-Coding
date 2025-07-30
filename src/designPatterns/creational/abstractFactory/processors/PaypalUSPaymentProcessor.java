package designPatterns.creational.abstractFactory.processors;

public class PaypalUSPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {

        System.out.println("Processed "+amount+" using PAYPAL US");
    }
}
