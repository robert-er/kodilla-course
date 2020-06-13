package com.kodilla.testing.shape;

public class Square implements Shape {

    private double a;
    private int number;
    private static int counter = 0;

    public Square(double a) {
        this.a = a;
        counter++;
        this.number = counter;
    }

    @Override
    public String getShapeName() {
        return String.valueOf(Square.class) + number;
    }

    @Override
    public double getField() {
        return Math.pow(a, 2);
    }
}
