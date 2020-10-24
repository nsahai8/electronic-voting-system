package model;

import java.util.UUID;

public class Party {

    private UUID Id;
    private String name;
    private String signImageUrl;

    public Party(String name, String signImageUrl) {
        this.Id = UUID.randomUUID();
        this.name = name;
        this.signImageUrl = signImageUrl;
    }

    public String getName() {
        return name;
    }
}
