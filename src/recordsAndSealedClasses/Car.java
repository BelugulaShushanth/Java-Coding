package recordsAndSealedClasses;

public record Car(String name, String model) implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Car brakes applied");
    }
}
