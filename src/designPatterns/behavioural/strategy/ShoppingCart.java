package designPatterns.behavioural.strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    public ShoppingCart(){
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amt){
        paymentStrategy.pay(amt);
    }
}
