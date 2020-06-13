package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> shapeCollection = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapeCollection.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapeCollection.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapeCollection.get(n);
    }

    public ArrayList<Shape> showFigures() {
        return shapeCollection;
    }

}
