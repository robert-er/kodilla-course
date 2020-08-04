package com.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;

public class FlightDB {

    private List<Flight> flightList = new ArrayList<>();

    public void addFlight(Flight flight) {
        if (!flightList.contains(flight.getDepartureAirport())) {
            flightList.add(flight);
        } else {
            System.out.println("addAirport: airport already exist on the list");
        }
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}
