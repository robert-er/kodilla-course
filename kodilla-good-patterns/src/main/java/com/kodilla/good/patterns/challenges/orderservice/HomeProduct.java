package com.kodilla.good.patterns.challenges.orderservice;

public class HomeProduct implements Product{

    private static int idCounter;
    private int id;
    private User seller;
    private Category category;
    private String name;
    private double price;
    private String description;

    public HomeProduct(User seller, Category category, String name, double price, String description) {
        this.seller = seller;
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.id = idCounter++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public User getSeller() {
        return seller;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

enum Category {
    GAMES, SHOES, TVS, PHONES, BIKES, CARS, TRUCKS
}
