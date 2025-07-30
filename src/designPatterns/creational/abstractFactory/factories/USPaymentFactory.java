package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.processors.PaymentProcessor;
import designPatterns.creational.abstractFactory.processors.PaypalUSPaymentProcessor;
import designPatterns.creational.abstractFactory.processors.StripePaymentProcessor;

public class USPaymentFactory implements PaymentFactory{
    @Override
    public PaymentProcessor createProcessor(String paymentType) {
        if(paymentType.equals("STRIPE")){
            return new StripePaymentProcessor();
        } else if (paymentType.equals("PAYPAL")) {
            return new PaypalUSPaymentProcessor();
        }else{
            return null;
        }
    }
}
