package designPatterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        VehcileFactory factory = new CarFactory();
        factory.create().drive();
        factory = new BikeFactory();
        factory.create().drive();
    }
}
