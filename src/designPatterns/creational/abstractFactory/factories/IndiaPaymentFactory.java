package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.processors.PaymentProcessor;
import designPatterns.creational.abstractFactory.processors.PaytmPaymentProcessor;
import designPatterns.creational.abstractFactory.processors.UPIPaymentProcessor;

public class IndiaPaymentFactory implements PaymentFactory{


    @Override
    public PaymentProcessor createProcessor(String paymentType) {
        if(paymentType.equals("UPI")){
            return new UPIPaymentProcessor();
        }else if(paymentType.equals("PAYTM")){
            return new PaytmPaymentProcessor();
        }else{
            return null;
        }
    }
}
