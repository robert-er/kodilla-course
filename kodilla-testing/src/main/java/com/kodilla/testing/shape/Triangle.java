package com.kodilla.testing.shape;

import java.util.Objects;

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

    public double getA() {
        return a;
    }

    public double getH() {
        return h;
    }

    @Override
    public String getShapeName() {
        return String.valueOf(Triangle.class) + number;
    }

    @Override
    public double getField() {
        return 0.5 * a * h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;
        return this.a == triangle.getA() && this.h == triangle.getH();
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, h);
    }
}
