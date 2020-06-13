package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double r;
    private int number;
    private static final double pi = 3.14;
    private static int counter = 0;

    public Circle(double r) {
        this.r = r;
        counter++;
        this.number = counter;
    }

    @Override
    public String getShapeName() {
        return String.valueOf(Circle.class) + number;
    }

    @Override
    public double getField() {
        return pi * Math.pow(r, 2);
    }
}
