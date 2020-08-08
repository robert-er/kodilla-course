package com.kodilla.good.patterns.challenges.orderservice;

public class Main {

    public static void main(String[] args) {

        ProductOrderService productOrderService = new ProductOrderService(new EmailMessageService(), new Order(true));
        productOrderService.process();

        productOrderService = new ProductOrderService(new EmailMessageService(), new Order(false));
        productOrderService.process();
    }

}
