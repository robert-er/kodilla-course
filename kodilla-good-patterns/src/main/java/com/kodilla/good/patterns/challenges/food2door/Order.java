package com.kodilla.good.patterns.challenges.food2door;

public class Order {

    private static int idCounter;
    private int id;
    private Supplier supplier;
    private Product product;
    private int quantity;
    private User user;

    public Order(Supplier supplier, Product product, int quantity, User user) {
            idCounter++;
            this.id = idCounter;
            this.supplier = supplier;
            this.product = product;
            this.quantity = quantity;
            this.user = user;
    }

    public void process() {
        if (supplier.isAvailable(product, quantity)) {
            System.out.println("Order id: " + id + " is processed.");
            product.subQuantity(quantity);
        } else {
            System.out.println("Create order: product not available.");
        }
    }
}
