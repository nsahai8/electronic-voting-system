package com.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Address {
    private final String streetName;
    private final Integer areaCode;
    private final State state;
}
