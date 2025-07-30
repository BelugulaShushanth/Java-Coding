package designPatterns.creational.prototype.copyConstructorPrototype;

public class Circle extends Shape {

    private int r;

    public Circle(){}

    public Circle(Circle circle){
        super(circle);
        if(circle != null){
            this.r = circle.r;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

}
