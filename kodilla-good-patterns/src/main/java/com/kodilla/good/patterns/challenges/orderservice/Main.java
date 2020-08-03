package com.kodilla.good.patterns.challenges.orderservice;

public class Main {

    public static void main(String[] args) {
        Order order1 = createOrder();
        order1.pay();
    }

    private static User createSeller() {
        return new User("Bill Gates", "bgates@microsoft.com",
                "ul. Softwareowa 88, 00-999 Warszawa", 505487230);

    }

    private static User createBuyer() {
        return new User("Jan Kowalski", "jkowal@ski.pl",
                "ul. Potokowa 23, 23-324 Puck", 984364578);
    }

    private static Order createOrder() {
        User buyer = createBuyer();
        User seller = createSeller();
        return new Order(new Vehicles(seller, Category.CARS, "AUDI",
                16109.78, "Niemec plakal jak sprzedawal", 99505), buyer);
    }
}
