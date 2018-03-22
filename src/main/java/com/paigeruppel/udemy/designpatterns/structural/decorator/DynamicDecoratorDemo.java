package com.paigeruppel.udemy.designpatterns.structural.decorator;

public class DynamicDecoratorDemo {

}

interface Shape {
    String info();
}

class Circle implements Shape {

    private float radius;

    public Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "a circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "a square with sides equal to " + side;
    }
}

class ColoredShape implements Shape {

    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape implements Shape {

    private Shape shape;
    private int opacity;

    public TransparentShape(Shape shape, int opacity) {
        this.shape = shape;
        this.opacity = opacity;
    }

    @Override
    public String info() {
        return shape.info() + " has opacity facotr of " + opacity;
    }
}