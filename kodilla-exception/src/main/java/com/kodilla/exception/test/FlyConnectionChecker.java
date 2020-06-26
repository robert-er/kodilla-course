package com.kodilla.exception.test;

public class FlyConnectionChecker {
    public void checkConnection(Flight flight) {
        FlightFinder flightFinder = new FlightFinder();
        boolean result = false;
        if (flight!=null) {
            System.out.println("Checking connection from " + flight.getDepartureAirport() + " to "
                    + flight.getArrivalAirport() + " ... ");
            try {
                result = flightFinder.findFlight(flight);
            } catch (RouteNotFoundException e) {
                System.out.println("Flight not found. Exception: " + e);
            }
            if (result) {
                System.out.println("Connection from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport()
                        + " is possible");
            } else {
                System.out.println("Connection from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport()
                        + " is NOT possible");
            }
        } else {
            System.out.println("Exception: empty query");
        }
    }
}
