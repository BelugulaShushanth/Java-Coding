package equalsHashCodeExample;

public class Person {
    private int pId;
    private String pName;

    public Person(){
    }

    public Person(int pId, String pName){
        this.pId = pId;
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + pName +
                ", name='" + pName + '\'' +
                '}';
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(! (o instanceof Person p)) return false;
        return this.pId == p.pId && ( (p.pName==null && this.pName==null)
                || (p.pName!=null && p.pName.equals(this.pName)) );
    }

    public int hashcode(){
        int res = 21;
        if(this.pName != null){
            res = res * 30 + pName.hashCode();
        }
        return res;
    }
}
