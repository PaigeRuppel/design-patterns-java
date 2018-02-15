package com.paigeruppel.udemy.designpatterns.creational.factories;

public class FactoryMethodDemo {
    Point p = Point.newPolarPoint(2, 3);
}

class Point {
    private double x, y;

    // hide your constructor so that the user has to explicitly call one of the factory methods
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // factory methods allow you to clearly name your signatures and parameters


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

// another option is to have all of your factory methods grouped under one factory class
class PointFactory {
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        double x = rho * Math.cos(theta);
        double y = rho * Math.sin(theta);
        return new Point(x, y);
    }
}