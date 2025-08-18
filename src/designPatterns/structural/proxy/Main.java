package designPatterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("demo.jpg");
        image.display();
        image.display();
    }
}
