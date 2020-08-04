package com.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;

public class AirportDB {

    private List<Airport> airportsList = new ArrayList<>();

    public void addAirport(Airport airport) {
        if (!airportsList.contains(airport.getDepartureAirport())) {
            airportsList.add(airport);
        } else {
            System.out.println("addAirport: airport already exist on the list");
        }
    }

    public List<Airport> getAirportsList() {
        return airportsList;
    }
}
