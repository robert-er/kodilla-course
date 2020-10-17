package com.kodilla.patterns2.decorator.pizza;

public class HamDecorator extends AbstractPizzaDecorator {

    public HamDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return super.getCost() + 3;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }
}
