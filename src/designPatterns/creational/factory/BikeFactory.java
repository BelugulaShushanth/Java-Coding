package designPatterns.creational.factory;

public class BikeFactory implements VehcileFactory{
    @Override
    public Vehcile create() {
        return new Bike();
    }
}
