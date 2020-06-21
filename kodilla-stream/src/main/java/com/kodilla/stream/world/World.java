package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World implements Population{
    private final List<Continent> continentList = new ArrayList<>();

    @Override
    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addContinent(Continent continent) {
        continentList.add(continent);
    }
}
