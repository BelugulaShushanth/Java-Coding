package designPatterns.creational.abstractFactory.processors;

public class PaytmPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processed "+amount+" using PAYTM India");
    }
}
