package com.kodilla.good.patterns.challenges.orderservice;

public class ProductOrderService {

    private OrderService orderService;
    private Product product;
    private UserRepositoryService userRepositoryService = new UserRepository();

    public void process() {
        Order order = createOrder();
        order.pay();
        order.send();
        order.close();
    }

    private Order createOrder() {
        User buyer = userRepositoryService.getBuyer();
        User seller = userRepositoryService.getSeller();
        return new Order(new Vehicles(seller, Category.CARS, "AUDI",
                16109.78, "Niemec plakal jak sprzedawal", 99505), buyer);
    }
}
