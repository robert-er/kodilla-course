package com.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private String departureAirport;
    private List<String> arrivalAirports = new ArrayList<>();

    public Airport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void addArrivalAirport(String airport) {
       if (!arrivalAirports.contains(airport)) {
           arrivalAirports.add(airport);
       } else {
           System.out.println("Destination already exist on the connection list.");
       }
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public List<String> getArrivalAirports() {
        return arrivalAirports;
    }
}
