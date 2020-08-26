package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class Destinations {
    private Map<String, Boolean> destinationsMap = new HashMap<>();

    public void addDestination(String arrivalAirport) {
        destinationsMap.put(arrivalAirport, true);
    }

    public Map<String, Boolean> getDestinationsMap() {
        return destinationsMap;
    }
}
