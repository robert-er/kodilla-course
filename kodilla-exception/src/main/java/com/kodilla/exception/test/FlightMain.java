package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args) {
        Destinations wroclaw = new Destinations();
        wroclaw.addDestination("Warszawa");
        wroclaw.addDestination("Gdańsk");

        Destinations warszawa = new Destinations();
        warszawa.addDestination("Wrocław");
        warszawa.addDestination("Frankfurt");
        warszawa.addDestination("Paryż");

        AirportsDatabase airportsDatabase = new AirportsDatabase();
        airportsDatabase.addDestinationsMap("Wrocław", wroclaw);
        airportsDatabase.addDestinationsMap("Warszawa", warszawa);

        Flight flight1 = new Flight("Wrocław", "Warszawa");
        Flight flight2 = new Flight("Wrocław", "Paryż");
        Flight flight3 = new Flight("Warszawa", "Oslo");
        Flight flight4 = new Flight("Warszawa", "Frankfurt");
        Flight flight5 = null;
        Flight flight6 = new Flight("Nie_istnieje", "Warszawa");

        FlyConnectionChecker flyConnectionChecker = new FlyConnectionChecker();
        flyConnectionChecker.checkConnection(flight1, airportsDatabase);
        flyConnectionChecker.checkConnection(flight2, airportsDatabase);
        flyConnectionChecker.checkConnection(flight3, airportsDatabase);
        flyConnectionChecker.checkConnection(flight4, airportsDatabase);
        flyConnectionChecker.checkConnection(flight5, airportsDatabase);
        flyConnectionChecker.checkConnection(flight6, airportsDatabase);
    }
}
