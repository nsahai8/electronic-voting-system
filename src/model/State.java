package model;

import java.util.UUID;

public class State {

    private UUID Id;
    private String name;
    private UUID countryId;

    public State(String stateName, UUID countryId) {
        this.Id = UUID.randomUUID();
        this.name = stateName;
        this.countryId = countryId;
    }

    public static State findByName(String stateName) {
        return new State(stateName, UUID.randomUUID());//assuming countryId as random for now
    }

    public String getName() {
        return name;
    }
}
