package serializationExample;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.stream.Stream;

public class User implements Serializable {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private void writeObject(ObjectOutputStream o) throws IOException {
        System.out.println("In write");
        o.writeUTF(this.username);
        String encodedPwd = Base64.getEncoder().encodeToString(this.password.getBytes());
        System.out.println(encodedPwd);
        o.writeUTF(encodedPwd);
    }

    private void readObject(ObjectInputStream i) throws IOException {
        System.out.println("In read");
        this.username = i.readUTF();
        this.password = new String(Base64.getDecoder().decode(i.readUTF()), StandardCharsets.UTF_8);
        System.out.println(this.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
