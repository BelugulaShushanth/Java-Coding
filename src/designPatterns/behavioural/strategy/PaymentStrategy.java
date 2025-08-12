package designPatterns.behavioural.strategy;

public interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;

    public CreditCardPayment(String name) {
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Credit Card. Name: " + this.name);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) { this.email = email; }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal account: " + email);
    }
}

