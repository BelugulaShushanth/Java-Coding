package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.processors.PaymentProcessor;
import designPatterns.creational.abstractFactory.processors.PaypalEUPaymentProcessor;
import designPatterns.creational.abstractFactory.processors.SEPAPaymentProcessor;


public class EuropePaymentFactory implements PaymentFactory{
    @Override
    public PaymentProcessor createProcessor(String paymentType) {
        if(paymentType.equals("SEPA")){
            return new SEPAPaymentProcessor();
        }else if(paymentType.equals("PAYPAL")){
            return new PaypalEUPaymentProcessor();
        }else{
            return null;
        }
    }
}
