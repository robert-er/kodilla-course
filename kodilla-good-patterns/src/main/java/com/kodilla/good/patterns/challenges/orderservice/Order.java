package com.kodilla.good.patterns.challenges.orderservice;

public class Order {

    private static int idCounter;
    private int id;
    private Product product;
    private User buyer;
    private Status status;

    public Order(Product product, User buyer) {
        this.product = product;
        this.buyer = buyer;
        this.status = Status.NEW;
        this.id = idCounter++;
    }

    public Product getProduct() {
        return product;
    }

    public User getBuyer() {
        return buyer;
    }

    public Status getStatus() {
        return status;
    }

    public void pay() {
        isClosed();
        isCancelled();
        isPaid();
        status = Status.PAID;
        System.out.println("Order id: " + id + ", " + product.getName() + " was paid.");
    }

    public void send() {
        isClosed();
        isCancelled();
        isSent();
        status = Status.SENT;
        System.out.println("Order id: " + id + ", " + product.getName() + " was sent.");

    }

    public void cancel() {
        isClosed();
        isCancelled();
        status = Status.SENT;
        System.out.println("Order id: " + id + ", " + product.getName() + " was sent.");
    }

    public void close() {
        isClosed();
        status = Status.CLOSED;
        System.out.println("Order id: " + id + ", " + product.getName() + " was closed.");
    }

    private void isClosed() {
        if ( status == Status.CLOSED) {
            System.out.println("Order id: "+ id + ", " + product.getName() + " already closed.");
        }
    }

    private void isCancelled() {
        if (status == Status.CANCELLED) {
            System.out.println("Order id: "+ id + ", " + product.getName() + " already cancelled.");
        }
    }

    private void isSent() {
        if (status == Status.SENT) {
            System.out.println("Order id: "+ id + ", " + product.getName() + " already sent.");
        }
    }

    private void isPaid() {
        if (status == Status.PAID) {
            System.out.println("Order id: "+ id + ", " + product.getName() + " already paid.");
        }
    }
}

enum Status {
    NEW, PAID, SENT, CANCELLED, CLOSED
}