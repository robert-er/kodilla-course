package com.kodilla.good.patterns.challenges.food2door;

public class Order {

    private static int idCounter;
    private int id;
    private Product product;
    private int quantity;
    private User user;

    public Order(Product product, int quantity, User user) {
            idCounter++;
            this.id = idCounter;
            this.product = product;
            this.quantity = quantity;
            this.user = user;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }

}
