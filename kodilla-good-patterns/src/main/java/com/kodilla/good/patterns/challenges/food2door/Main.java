package com.kodilla.good.patterns.challenges.food2door;

public class Main {

    private static User user;
    private static Supplier supplier1, supplier2, supplier3;
    private static Product product1, product2, healthyProduct1;

    public static void main(String[] args) {
        createUsers();
        createSuppliers();
        FoodOrderManager foodOrderManager = new FoodOrderManager();
        foodOrderManager.processOrder(supplier1, new Order(product1, 20, user));
    }

    private static void createUsers() {
        user = new User("Jan Kowalski", "jkowal@ski.pl",
                "ul. Potokowa 23, 23-324 Puck", 984364578);
    }

    private static void createSuppliers() {
        supplier1 = new Supplier("ExtraFoodShop");
        product1 = new Product("Ciastka", 2);
        product1.addQuantity(100);
        supplier1.addProduct(product1);
        product2 = new Product("Baton", 4);
        product2.addQuantity(200);
        supplier1.addProduct(product2);
        supplier2 = new Supplier("HealthyShop");
        healthyProduct1 = new Product("Ciastka sojowe", 5);
        healthyProduct1.addQuantity(12);
        supplier2.addProduct(healthyProduct1);
        supplier3 = new Supplier("GlutenFreeShop");
    }

}
