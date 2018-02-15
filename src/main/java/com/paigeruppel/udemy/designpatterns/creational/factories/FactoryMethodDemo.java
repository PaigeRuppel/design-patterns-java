package com.paigeruppel.udemy.designpatterns.creational.factories;

public class FactoryMethodDemo {
}

enum CoordinateSystem{
    CARTESIAN, POLAR
}
class Point {
    private double x, y;

// This is ugly
    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs) {
            case CARTESIAN:
                x = a;
                y = b;
                break;
            case POLAR:
                x = a * Math.cos(b);
                y = a * Math.sin(b);
        }
    }

 /*   public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

  Would be nice to do this... but you can't
    public Point(double rho, double theta) {
        x = rho * Math.cos(theta);
        y = rho * Math.sin(theta);
    }*/
}