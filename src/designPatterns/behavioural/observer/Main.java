package designPatterns.behavioural.observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addObserver(new PhoneObserver());
        weatherStation.addObserver(new TVObserver());
        weatherStation.setTemperature(25);
        weatherStation.setTemperature(30);
    }
}
