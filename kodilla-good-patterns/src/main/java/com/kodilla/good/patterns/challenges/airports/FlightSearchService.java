package com.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchService {

    private final FlightDB flightDB;

    public FlightSearchService(FlightDB flightDB) {
        this.flightDB = flightDB;
    }

    public List<String> findFlightsFrom(String flyFrom) {
        List<String> flightsFromList = new ArrayList<>();
        for (int i = 0; i < flightDB.getFlightList().size(); i++ ) {
            if (flyFrom.equals(flightDB.getFlightList().get(i).getDepartureAirport())) {
                flightsFromList = flightDB.getFlightList().get(i).getArrivalAirports();
            }
        }
        return flightsFromList;
    }

    public List<String> findFlightsTo(String flyTo) {
        List<String> flightsToList = new ArrayList<>();


        for (int i = 0; i < flightDB.getFlightList().size(); i++) {
            if (flightDB.getFlightList().get(i).getArrivalAirports().contains(flyTo)) {
                flightsToList.add(flightDB.getFlightList().get(i).getDepartureAirport());
            }
        }
        return flightsToList;
    }

    public List<String> findFlightsThrough(String flyFrom, String flyTo) {
        List<String> flightsFromList = findFlightsFrom(flyFrom);
        List<String> flightsToList = findFlightsTo(flyTo);
        List<String> flightsThroughList =  new ArrayList<>();
        for (String s : flightsFromList) {
            if (flightsToList.contains(s)) {
                flightsThroughList.add(s);
            }
        }
        return flightsThroughList;
    }

}
