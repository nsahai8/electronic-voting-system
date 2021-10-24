package com.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class State {

    private final UUID Id;
    private final String name;
    private final UUID countryId;

    private State(String stateName, UUID countryId) {
        this.Id = UUID.randomUUID();
        this.name = stateName;
        this.countryId = countryId;
    }

    public static State findByName(String stateName) {
        return new State(stateName, UUID.randomUUID());//assuming countryId as random for now
    }
}
