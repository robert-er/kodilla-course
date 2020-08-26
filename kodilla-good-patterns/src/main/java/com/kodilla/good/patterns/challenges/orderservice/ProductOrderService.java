package com.kodilla.good.patterns.challenges.orderservice;

public class ProductOrderService implements ProductOrderInterface {

    private MessageService messageService;
    private OrderService orderService;
    private OrderStatus orderStatus;

    public ProductOrderService(MessageService messageService, OrderService orderService) {
        this.messageService = messageService;
        this.orderService = orderService;
    }

    @Override
    public void process() {
        if (orderService.isCompleted()) {
            orderStatus = OrderStatus.SUCCESS;
        } else {
            orderStatus = OrderStatus.FAIL;
        }
        messageService.send("Order " + orderStatus.name());
    }

}
