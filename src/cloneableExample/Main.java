package cloneableExample;


public class Main {

    public static void main(String[] args) {
       Address a =  new Address("Hyd", "Telangana");
       Employee e = new Employee(1, "Jhon", a);
        System.out.println(e);
    }
}
