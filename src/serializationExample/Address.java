package serializationExample;

import java.io.Serializable;

public class Address implements Serializable {
    private String streetName;
    private String state;
    private int pincode;

    public Address(String streetName, String state, int pincode) {
        this.streetName = streetName;
        this.state = state;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
