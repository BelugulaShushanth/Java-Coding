package serializationExample;

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
}
