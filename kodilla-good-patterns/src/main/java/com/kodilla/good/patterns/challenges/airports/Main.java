package com.kodilla.good.patterns.challenges.airports;

public class Main {

    public static void main(String[] args) {

        Flight wroclaw = new Flight("Wroclaw");
        wroclaw.addArrivalAirport("Warszawa");
        wroclaw.addArrivalAirport("Gdansk");
        wroclaw.addArrivalAirport("Poznan");
        wroclaw.addArrivalAirport("Berlin");
        Flight warszawa = new Flight("Warszawa");
        warszawa.addArrivalAirport("Singapur");
        warszawa.addArrivalAirport("Frankfurt");
        warszawa.addArrivalAirport("Berlin");
        Flight poznan = new Flight("Poznan");
        poznan.addArrivalAirport("Frankfurt");
        poznan.addArrivalAirport("Warszawa");
        Flight berlin = new Flight("Berlin");
        berlin.addArrivalAirport("Oslo");
        berlin.addArrivalAirport("Paryz");
        berlin.addArrivalAirport("Warszawa");
        FlightDB flightDB = new FlightDB();
        flightDB.addFlight(wroclaw);
        flightDB.addFlight(poznan);
        flightDB.addFlight(warszawa);
        flightDB.addFlight(berlin);
        FlightSearchService flightSearchService = new FlightSearchService(flightDB);

        System.out.println("From Wroclaw: " + flightSearchService.findFlightsFrom("Wroclaw"));
        System.out.println("To Berlin from: " + flightSearchService.findFlightsTo("Berlin"));
        System.out.println("From Wroclaw to Frankfurt through: " + flightSearchService.findFlightsThrough("Wroclaw", "Frankfurt"));
    }

}
