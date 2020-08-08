package com.kodilla.good.patterns.challenges.food2door;

public class HealthySupplier implements FoodSupplier {

    private String name;

    public HealthySupplier(String name) {
        this.name = name;
    }

    @Override
    public void process(Order order) {
        System.out.println("For the sake of your health, please come and pick your order by yourself.");
    }

}
