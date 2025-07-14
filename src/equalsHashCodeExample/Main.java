package equalsHashCodeExample;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //Employee e1 = new Employee(1, "emp1", "dept1", 2, "pName1");
       // Employee e2= new Employee(2, "emp2", "dept2", 3, "pName1");
//        System.out.println(e1.equals(e2));
//        System.out.println(e2.equals(e1));

        Employee e1 = new Employee(1, "emp1", "dept1");
        Employee e2= new Employee(2, "emp2", "dept2");

        HashMap<Employee, String> map = new HashMap<>();
        map.put(e1,"E1");
        map.put(e2, "E2");

        Employee e3 = new Employee(1, "emp1", "dept1");
        System.out.println(e1.hashCode()+" "+e3.hashCode());
        System.out.println(map.get(e3));
    }
}
