package designPatterns.creational.abstractFactory.processors;

public class SEPAPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processed "+amount+" using SEPA EU");
    }
}
