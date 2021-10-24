package com.model;

import java.util.UUID;

public class Country {

    private final UUID Id;
    private final String name;

    public Country(String countryName) {
        this.Id = UUID.randomUUID();
        this.name = countryName;
    }

    public String getName() {
        return name;
    }
}
