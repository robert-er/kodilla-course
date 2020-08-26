package com.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flight {

    private String departureAirport;
    private List<String> arrivalAirports = new ArrayList<>();

    public Flight(String departureAirport) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(arrivalAirports, flight.arrivalAirports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, arrivalAirports);
    }

}
