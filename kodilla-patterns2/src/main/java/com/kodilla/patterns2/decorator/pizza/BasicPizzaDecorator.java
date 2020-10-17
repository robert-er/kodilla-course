package com.kodilla.patterns2.decorator.pizza;

public class BasicPizzaDecorator implements Pizza {

   @Override
    public int getCost() {
        return 15;
    }

    @Override
    public String getDescription() {
        return "Pizza: sauce + cheese";
    }
}
