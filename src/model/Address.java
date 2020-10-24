package model;

public class Address {


    private String streetName;
    private Integer areaCode;
    private State state;

    public Address(String streetName, Integer areaCode, String stateName) {
        this.streetName = streetName;
        this.areaCode = areaCode;
        this.state = State.findByName(stateName);
    }

}
