package recordsAndSealedClasses;

public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee(1,"EMP1", "DEPT1");
        System.out.println(e1);
        System.out.println(e1.name());

        Vehicle vehicle1 = new Car("Tesla", "Model Y");
        Vehicle vehicle2 = new Bike("Yamaha", "R15");
        System.out.println(vehicle1);
        System.out.println(vehicle2);
    }

}
