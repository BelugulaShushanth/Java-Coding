package serializationExample;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = -1234567890123456789L;

    static String ORGANIZATION_NAME = "EPAM";

    private int empId;
    private String empName;
    private transient String empDept;
    private Address address;

    public Employee(){
        super();
    }

    public Employee(int empId, String empName, String empDept, Address address) {
        super(1,"JavaP");
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + empId +
                ", name='" + empName + '\'' +
                ", dept='" + empDept + '\'' +
                ", address='" + address + '\'' +
                ", pId='" + getpId() + '\'' +
                ", pName='" + getpName() + '\'' +
                '}';
    }
}
