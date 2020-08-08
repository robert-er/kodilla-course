package com.kodilla.good.patterns.challenges.food2door;

public class ExtraSupplier implements FoodSupplier {

    private String name;

    public ExtraSupplier(String name) {
        this.name = name;
    }

    @Override
    public void process(Order order) {
        System.out.println("This is Extra Shop. We will send you your order even if is not available.");
    }

}
