package com.kodilla.good.patterns.challenges.orderservice;

public class Vehicles extends HomeProduct implements Product{

    private int odometer;

    public Vehicles(User seller, Category category, String name, double price, String description, int odometer) {
        super(seller, category, name, price, description);
        this.odometer = odometer;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public User getSeller() {
        return super.getSeller();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public int getOdometer() {
        return odometer;
    }

}
