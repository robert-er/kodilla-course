package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double a;
    private double h;
    private int number;
    private static int counter = 0;

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
        counter++;
        this.number = counter;
    }

    @Override
    public String getShapeName() {
        return String.valueOf(Triangle.class) + number;
    }

    @Override
    public double getField() {
        return 0.5 * a * h;
    }
}
