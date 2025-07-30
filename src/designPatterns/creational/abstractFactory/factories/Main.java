package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.processors.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        String country = "EUROPE";
        String paymentType = "PAYPAL";
        PaymentFactory paymentFactory = switch (country) {
            case "INDIA" -> new IndiaPaymentFactory();
            case "EUROPE" -> new EuropePaymentFactory();
            case "USA" -> new USPaymentFactory();
            default -> throw new IllegalArgumentException("Invalid country: " + country);
        };
        PaymentProcessor paymentProcessor = paymentFactory.createProcessor(paymentType);
        paymentProcessor.processPayment(200);

    }
}
