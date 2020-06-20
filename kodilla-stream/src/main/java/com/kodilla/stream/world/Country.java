package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country implements Population{
    private final BigDecimal peopleQuantity;

    public Country(String peopleQuantity) {
        this.peopleQuantity = new BigDecimal(peopleQuantity);
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }
}
