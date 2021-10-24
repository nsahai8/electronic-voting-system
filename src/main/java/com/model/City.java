package com.model;

import java.util.UUID;

public class City {

    private UUID id;
    private String name;
    private UUID stateId;

    public City(String cityName, UUID stateId){
        this.id = UUID.randomUUID();
        this.name = cityName;
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }
}
