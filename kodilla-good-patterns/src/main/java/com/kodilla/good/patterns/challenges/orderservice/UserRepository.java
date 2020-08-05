package com.kodilla.good.patterns.challenges.orderservice;

public class UserRepository implements UserRepositoryService{

    private User createSeller() {
        return new User("Bill Gates", "bgates@microsoft.com",
                "ul. Softwareowa 88, 00-999 Warszawa", 505487230);

    }

    private User createBuyer() {
        return new User("Jan Kowalski", "jkowal@ski.pl",
                "ul. Potokowa 23, 23-324 Puck", 984364578);
    }

    @Override
    public User getSeller() {
        return createSeller();
    }

    @Override
    public User getBuyer() {
        return createBuyer();
    }
}
