package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> isPossibleTo = new HashMap<>();
        boolean result = false;
        switch (flight.getDepartureAirport()) {
            case "Wrocław" : {
                isPossibleTo = getPossibleDestinationsForWroclaw();
                break;
            }
            case "Warszawa" : {
                isPossibleTo = getPossibleDestinationsForWarszawa();
                break;
            }
        }

        if (!isPossibleTo.keySet().contains(flight.getArrivalAirport())) {
            throw new RouteNotFoundException();
        }

        for (Map.Entry<String, Boolean> entry:isPossibleTo.entrySet()) {
            if (entry.getKey().equals(flight.getArrivalAirport())) {
                result = entry.getValue();
            }
        }
        return result;
    }

    private Map<String, Boolean> getPossibleDestinationsForWroclaw() {
        Map<String, Boolean> isPossibleTo = new HashMap<>();
        isPossibleTo.put("Warszawa", true);
        isPossibleTo.put("Gdańsk", true);
        return  isPossibleTo;
    }

    private Map<String, Boolean> getPossibleDestinationsForWarszawa() {
        Map<String, Boolean> isPossibleTo = new HashMap<>();
        isPossibleTo.put("Wrocław", true);
        isPossibleTo.put("Frankfurt", true);
        isPossibleTo.put("Paryż", true);
        return  isPossibleTo;
    }
}