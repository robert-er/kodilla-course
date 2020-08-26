package com.kodilla.good.patterns.challenges.orderservice;

public class EmailMessageService implements MessageService {

    @Override
    public void send(String message) {
        System.out.println("message sent: " + message);
    }

}
