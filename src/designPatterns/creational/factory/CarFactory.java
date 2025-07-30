package designPatterns.creational.factory;

public class CarFactory implements VehcileFactory{
    @Override
    public Vehcile create() {
        return new Car();
    }
}
