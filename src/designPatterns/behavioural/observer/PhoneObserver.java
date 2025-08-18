package designPatterns.behavioural.observer;

public class PhoneObserver implements Observer{
    @Override
    public void update(double temperature) {
        System.out.println("Phone display: weather updated "+temperature);
    }
}
