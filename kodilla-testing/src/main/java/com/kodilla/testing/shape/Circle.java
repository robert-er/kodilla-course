package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumPost;

import java.util.Objects;

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

    public double getR() {
        return r;
    }

    @Override
    public String getShapeName() {
        return Circle.class.getName() + number;
    }

    @Override
    public double getField() {
        return pi * Math.pow(r, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;
        return this.r == circle.getR();
    }

    @Override
    public int hashCode() {
        return Objects.hash(r);
    }
}
