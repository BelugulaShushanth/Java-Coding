package serializationExample;

import java.io.*;

public class DeSerializationMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "C:\\Users\\shushanth_belugula\\projects\\Java-Coding\\resources\\employee.ser";

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee e1 = (Employee) ois.readObject();
        System.out.println(e1);
//        User user1 = (User) ois.readObject();
//        System.out.println(user1);
        ois.close();
        fis.close();
    }
}