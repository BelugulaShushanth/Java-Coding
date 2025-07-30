package designPatterns.creational.prototype.copyConstructorPrototype;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setX(1);
        circle.setY(5);
        circle.setColor("Blue");
        circle.setR(10);
        System.out.println(circle);
        Shape clone = circle.clone();
        System.out.println(clone);
    }
}
