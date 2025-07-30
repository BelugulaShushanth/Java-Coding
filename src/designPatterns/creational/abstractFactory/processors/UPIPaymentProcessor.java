package designPatterns.creational.abstractFactory.processors;

public class UPIPaymentProcessor implements PaymentProcessor{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processed "+amount+" using UPI India");
    }
}
