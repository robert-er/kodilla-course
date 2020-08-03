package com.kodilla.good.patterns.challenges.orderservice;

public interface Product {

    int getId();
    User getSeller();
    String getName();
    double getPrice();
    String getDescription();

}
