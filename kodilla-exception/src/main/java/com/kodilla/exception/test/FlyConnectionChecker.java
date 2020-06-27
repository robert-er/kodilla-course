package com.kodilla.exception.test;

public class FlyConnectionChecker {
    public void checkConnection(Flight flight, AirportsDatabase airportsDatabase) {
        FlightFinder flightFinder = new FlightFinder();
        boolean result = false;
        if (flight!=null) {
            System.out.println("Checking connection from " + flight.getDepartureAirport() + " to "
                    + flight.getArrivalAirport() + " ... ");
            try {
                result = flightFinder.findFlight(flight, airportsDatabase);
            } catch (RouteNotFoundException e) {
                System.out.println("Flight not found. Exception: " + e);
            } catch (DepartureNotFoundException e) {
                System.out.println("Departure airport not found. Exception: " + e);
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
