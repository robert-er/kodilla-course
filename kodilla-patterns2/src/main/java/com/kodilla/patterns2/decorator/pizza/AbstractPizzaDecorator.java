package com.kodilla.patterns2.decorator.pizza;

public abstract class AbstractPizzaDecorator implements Pizza {

    private final Pizza pizza;

    protected AbstractPizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
