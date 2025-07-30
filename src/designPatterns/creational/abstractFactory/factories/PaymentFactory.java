package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.processors.PaymentProcessor;

public interface PaymentFactory {
    PaymentProcessor createProcessor(String paymentType);
}
