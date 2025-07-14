package cloneableExample;

public class Employee implements Cloneable{
    private int empId;
    private String empName;
    private Address address;

    public Employee(int empId, String empName, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", address=" + address +
                '}';
    }
}
