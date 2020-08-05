package com.kodilla.good.patterns.challenges.airports;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {

    private final FlightDB flightDB;

    public FlightSearchService(FlightDB flightDB) {
        this.flightDB = flightDB;
    }

    public List<String> findFlightsFrom(String flyFrom) {
        return flightDB.getFlightList().stream()
                .filter(flight -> flight.getDepartureAirport().equals(flyFrom))
                .map(Flight::getArrivalAirports)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<String> findFlightsTo(String flyTo) {
        return flightDB.getFlightList().stream()
                .filter(flight -> flight.getArrivalAirports().contains(flyTo))
                .map(Flight::getDepartureAirport)
                .collect(Collectors.toList());
    }

    public List<String> findFlightsThrough(String flyFrom, String flyTo) {
        List<String> flightsFromList = findFlightsFrom(flyFrom);
        List<String> flightsToList = findFlightsTo(flyTo);

        return flightsToList.stream()
                .filter(flightsFromList::contains)
                .collect(Collectors.toList());
    }

}
