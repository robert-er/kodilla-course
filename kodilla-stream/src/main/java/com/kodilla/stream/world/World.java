package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> continentList = new ArrayList<>();

    public void addContinent(Continent continent) {
        continentList.add(continent);
    }

    public List<Continent> getContinentList() {
        return continentList;
    }
}
