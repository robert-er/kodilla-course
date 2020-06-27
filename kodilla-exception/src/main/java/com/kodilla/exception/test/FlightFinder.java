package com.kodilla.exception.test;

import java.util.Map;

public class FlightFinder {
    public boolean findFlight(Flight flight, AirportsDatabase airportsDatabase)
            throws RouteNotFoundException, DepartureNotFoundException {
        boolean result = false;
        Destinations isPossibleTo = airportsDatabase.getDestinationsMap(flight.getDepartureAirport());

        if (!isPossibleTo.getDestinationsMap().containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException();
        }

        for (Map.Entry<String, Boolean> entry:isPossibleTo.getDestinationsMap().entrySet()) {
            if (entry.getKey().equals(flight.getArrivalAirport())) {
                result = entry.getValue();
            }
        }
        return result;
    }
}