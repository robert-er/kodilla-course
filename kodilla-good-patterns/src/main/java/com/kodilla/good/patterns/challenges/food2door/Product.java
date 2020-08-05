package com.kodilla.good.patterns.challenges.food2door;

public class Product {

    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity +=  quantity;
    }

    public void subQuantity(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("not enough quantity of " + name + ". Quantity is " + this.quantity + ". Order is " + quantity);
        }
    }

}
