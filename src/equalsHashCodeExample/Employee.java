package equalsHashCodeExample;

public class Employee{

    private int empId;
    private String empName;
    private String empDept;

    public Employee(){
        super();
    }

    public Employee(int empId, String empName, String empDept){
            //, int pId, String pName) {
        //super(pId, pName);
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + empId +
                ", name='" + empName + '\'' +
                ", dept='" + empDept + '\'' +
                '}';
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Employee e)) return false;
        return (e.empId == this.empId) && ( (e.empName == null && this.empName==null)
                || (e.empName!=null && e.empName.equals(this.empName)) )
                && ( (e.empDept == null && this.empDept == null)
                || (e.empDept!=null && e.empDept.equals(this.empDept)));
              //  && this.getpId() == e.getpId() && ( (e.getpName()==null && this.getpName()==null)
               // || (e.getpName()!=null && e.getpName().equals(this.getpName())) );
    }

    public final int hashCode(){
        int res = 18;
        if(this.empName != null){
            res = res * 31 + this.empName.hashCode();
        }
        if(this.empDept != null){
            res = res * 31 + this.empDept.hashCode();
        }
        System.out.println(this.empName.hashCode());
        System.out.println(this.empDept.hashCode());
        return res;
    }
}
