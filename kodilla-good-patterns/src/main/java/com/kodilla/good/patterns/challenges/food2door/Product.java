package com.kodilla.good.patterns.challenges.food2door;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                quantity == product.quantity &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}
