package comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"Jhon");
        Employee e2 = new Employee(2,"Alex");
        Employee e3 = new Employee(4,"Bob");
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        Collections.sort(employees);
        System.out.println(employees);

        Product p1 = new Product(1,"p1", 50.0, 4.5);
        Product p2 = new Product(2,"p2", 90.0, 4);
        Product p3 = new Product(5,"p3", 20.0, 3.2);
        Product p4 = new Product(3,"p4", 35.0, 4.8);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        ToDoubleFunction<Product> toDoubleFunction = p -> -p.getPricing();
        Comparator<Product> priceComparator = Comparator.comparingDouble(toDoubleFunction);
        Collections.sort(products, priceComparator);
        System.out.println(products);
    }
}
