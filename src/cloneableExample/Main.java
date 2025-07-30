package cloneableExample;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
       Address a =  new Address("Hyd", "Telangana");
       Employee e = new Employee(1, "Jhon", a);
       Employee eCloned = e.clone();
       eCloned.getAddress().setCity("Banglore");
        System.out.println(e);
        System.out.println(eCloned);
    }
}
