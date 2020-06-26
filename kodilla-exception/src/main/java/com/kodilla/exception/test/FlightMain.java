package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Wrocław", "Warszawa");
        Flight flight2 = new Flight("Wrocław", "Paryż");
        Flight flight3 = new Flight("Warszawa", "Oslo");
        Flight flight4 = new Flight("Warszawa", "Frankfurt");
        Flight flight5 = null;
        FlyConnectionChecker flyConnectionChecker = new FlyConnectionChecker();
        flyConnectionChecker.checkConnection(flight1);
        flyConnectionChecker.checkConnection(flight2);
        flyConnectionChecker.checkConnection(flight3);
        flyConnectionChecker.checkConnection(flight4);
        flyConnectionChecker.checkConnection(flight5);
    }
}
