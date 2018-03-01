package com.paigeruppel.udemy.designpatterns.structural.adapter;

public class AdapterCodeExercise {
    public static void main(String[] args) {
        Square square = new Square(4);
        SquareToRectangleAdapter sqAdapt = new SquareToRectangleAdapter(square);

        System.out.println(sqAdapt.getArea());
    }
}

class Square {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}

interface Rectangle {
    int getWidth();
    int getHeight();

    default int getArea() {
        return getWidth() * getHeight();
    }


}

class SquareToRectangleAdapter implements Rectangle {

    private Square square;

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.getSide();
    }

    @Override
    public int getHeight() {
        return square.getSide();
    }

    @Override
    public String toString() {
        return "SquareToRectangleAdapter{" +
                "square=" + square +
                '}';
    }
}
