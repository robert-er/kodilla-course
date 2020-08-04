package com.kodilla.good.patterns.challenges.airports;

public class Main {

    public static void main(String[] args) {

        Airport wroclaw = new Airport("Wroclaw");
        wroclaw.addArrivalAirport("Warszawa");
        wroclaw.addArrivalAirport("Gdansk");
        wroclaw.addArrivalAirport("Poznan");
        wroclaw.addArrivalAirport("Berlin");
        Airport warszawa = new Airport("Warszawa");
        warszawa.addArrivalAirport("Singapur");
        warszawa.addArrivalAirport("Frankfurt");
        warszawa.addArrivalAirport("Berlin");
        Airport poznan = new Airport("Poznan");
        poznan.addArrivalAirport("Frankfurt");
        poznan.addArrivalAirport("Warszawa");
        Airport berlin = new Airport("Berlin");
        berlin.addArrivalAirport("Oslo");
        berlin.addArrivalAirport("Paryz");
        berlin.addArrivalAirport("Warszawa");
        AirportDB airportDB = new AirportDB();
        airportDB.addAirport(wroclaw);
        airportDB.addAirport(poznan);
        airportDB.addAirport(warszawa);
        airportDB.addAirport(berlin);
        Connection connection = new Connection(airportDB);

        System.out.println("From Wroclaw: " + connection.findConnectionFrom("Wroclaw"));
        System.out.println("To Berlin from: " + connection.findConnectionTo("Berlin"));
        System.out.println("From Wroclaw to Frankfurt throw: " + connection.findConnectionThrow("Wroclaw", "Frankfurt"));
    }

}
