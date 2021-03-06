package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;

public class Supplier implements FoodSupplier {

    private String name;
    private List<Product> offerList = new ArrayList<>();

    public Supplier(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        offerList.add(product);
    }

    public boolean isOnTheList(Product product) {
        return offerList.contains(product);
    }

    public boolean isAvailable(Product product, int quantity) {
        if (isOnTheList(product)) {
            return quantity <= product.getQuantity();
        } else {
            System.out.println("product not on the list");
        }
        return false;
    }

    @Override
    public void process(Order order) {
        if (isAvailable(order.getProduct(), order.getQuantity())) {
            System.out.println("Order id: " + order.getId() + " is processed.");
            order.getProduct().subQuantity(order.getQuantity());
        } else {
            System.out.println("Create order: product not available.");
        }
    }
}
