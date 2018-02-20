package com.paigeruppel.udemy.designpatterns.creational.prototype;

public class PrototypeCodeExercise {
    public static void main(String[] args) {
        Line one = new Line(new Point(1, 0), new Point(1, 5));
        System.out.println(one);
        Line two = one.deepCopy();
        two.start.x = (10);
        two.start.y = (10);
        System.out.println(two);
    }
}

class Point {
    public int x;
    public int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    public Point start;
    public Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        Point newStart = new Point(start.x, start.y);
        Point newEnd = new Point(end.x, end.y);
        return new Line(newStart, newEnd);
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}