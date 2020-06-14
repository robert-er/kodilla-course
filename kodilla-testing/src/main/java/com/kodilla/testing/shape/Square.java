package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    private double a;
    private int number;
    private static int counter = 0;

    public Square(double a) {
        this.a = a;
        counter++;
        this.number = counter;
    }

    public double getA() {
        return a;
    }

    @Override
    public String getShapeName() {
        return String.valueOf(Square.class) + number;
    }

    @Override
    public double getField() {
        return Math.pow(a, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;
        return this.a == square.getA();
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
