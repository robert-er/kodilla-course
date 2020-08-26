package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeShape(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping list", "food", 25.0);
            case PAINTING:
                return new PaintingTask("Paint wall", "white", "wall");
            case DRIVING:
                return new DrivingTask("Pick girlfriend from work", "her work", "car");
            default:
                return null;
        }
    }
}
