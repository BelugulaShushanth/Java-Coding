package designPatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private final List<Observer> observerList = new ArrayList<>();
    private double temperature;

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observerList){
            o.update(temperature);
        }
    }

    public void setTemperature(double temp){
        this.temperature = temp;
        notifyObservers();
    }
}
