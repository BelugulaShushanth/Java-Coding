package serializationExample;

import java.io.*;

public class SerializationMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Address address = new Address("AB STREET", "TG", 500089);
        Employee e = new Employee(1, "Sushanth", "Java", address);
        System.out.println(e);
        String path = "C:\\Users\\shushanth_belugula\\projects\\Java-Coding\\resources\\employee.ser";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(e);
//        User user = new User("Shushanth", "Shushanth123");
//        oos.writeObject(user);

        oos.close();
        fos.close();
    }
}