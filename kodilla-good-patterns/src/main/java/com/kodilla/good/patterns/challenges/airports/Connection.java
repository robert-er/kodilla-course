package com.kodilla.good.patterns.challenges.airports;

import java.util.ArrayList;
import java.util.List;

public class Connection {

    private AirportDB airportDB;

    public Connection(AirportDB airportDB) {
        this.airportDB = airportDB;
    }

    public List<String> findConnectionFrom(String flyFrom) {
        List<String> listConnectionsFrom = new ArrayList<>();
        for (int i = 0; i < airportDB.getAirportsList().size(); i++ ) {
            if (flyFrom.equals(airportDB.getAirportsList().get(i).getDepartureAirport())) {
                listConnectionsFrom = airportDB.getAirportsList().get(i).getArrivalAirports();
            }
        }
        return listConnectionsFrom;
    }

    public List<String> findConnectionTo(String flyTo) {
        List<String> listConnectionsTo = new ArrayList<>();


        for (int i = 0; i < airportDB.getAirportsList().size(); i++) {
            if (airportDB.getAirportsList().get(i).getArrivalAirports().contains(flyTo)) {
                listConnectionsTo.add(airportDB.getAirportsList().get(i).getDepartureAirport());
            }
        }
        return listConnectionsTo;
    }

    public List<String> findConnectionThrow(String flyFrom, String flyTo) {
        List<String> connectionFrom = findConnectionFrom(flyFrom);
        List<String> connectionTo = findConnectionTo(flyTo);
        List<String> connectionThrow =  new ArrayList<>();
        for (int i = 0; i < connectionFrom.size(); i++) {
            if (connectionTo.contains(connectionFrom.get(i))) {
                connectionThrow.add(connectionFrom.get(i));
            }
        }
        return connectionThrow;
    }

}
