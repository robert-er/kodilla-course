package com.kodilla.patterns2.decorator.pizza;

public class ExtraCheeseDecorator extends AbstractPizzaDecorator {

    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return super.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + extra cheese";
    }
}
