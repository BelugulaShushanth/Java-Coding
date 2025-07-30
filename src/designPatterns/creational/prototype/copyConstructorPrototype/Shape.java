package designPatterns.creational.prototype.copyConstructorPrototype;

public abstract class Shape {
    private int x;
    private int y;
    private String color;

    public abstract Shape clone();

    public Shape(){}

    public Shape(Shape shape){
        if(shape != null){
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
