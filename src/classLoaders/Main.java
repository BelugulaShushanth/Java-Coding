package classLoaders;

import java.lang.ref.SoftReference;

public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();
        System.out.println(classLoader.getName());
        SoftReference<String> sr = new SoftReference<>("djhsjs");
    }
}
