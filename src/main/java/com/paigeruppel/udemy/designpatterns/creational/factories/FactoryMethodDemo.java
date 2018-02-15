package com.paigeruppel.udemy.designpatterns.creational.factories;

public class FactoryMethodDemo {
    Point p = Point.Factory.newPolarPoint(2, 3);
}

class Point {
    private double x, y;

    // hide your constructor so that the user has to explicitly call one of the factory methods
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // factory method pattern allow you to clearly name your signatures and parameters


    /*   public Point(double x, double y) {
           this.x = x;
           this.y = y;
       }

     Would be nice to do this... but you can't
       public Point(double rho, double theta) {
           x = rho * Math.cos(theta);
           y = rho * Math.sin(theta);
       }*/

// By making a nested static class, you are able to access the private constructor
    public static class Factory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            double x = rho * Math.cos(theta);
            double y = rho * Math.sin(theta);
            return new Point(x, y);
        }
    }
}

