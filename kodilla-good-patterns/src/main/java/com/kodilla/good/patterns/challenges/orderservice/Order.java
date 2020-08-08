package com.kodilla.good.patterns.challenges.orderservice;

public class Order implements OrderService {

    private boolean completed;

    public Order(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

}
