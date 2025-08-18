package designPatterns.behavioural.observer;

public class TVObserver implements Observer{
    @Override
    public void update(double temperature) {
        System.out.println("TV Display: weather updated: "+temperature);
    }
}
