package model;

import java.util.UUID;

public class Country {

    private UUID Id;
    private String name;

    public Country(String countryName){
        this.Id = UUID.randomUUID();
        this.name = countryName;
    }

    public String getName() {
        return name;
    }
}
