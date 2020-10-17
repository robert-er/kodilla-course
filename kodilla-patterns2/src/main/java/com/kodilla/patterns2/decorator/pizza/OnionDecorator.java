package com.kodilla.patterns2.decorator.pizza;

public class OnionDecorator extends AbstractPizzaDecorator {

    public OnionDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return super.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + onion";
    }
}
