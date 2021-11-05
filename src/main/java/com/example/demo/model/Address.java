package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    private final String street;
    private final String city;
    private final String state;
    private final Integer postalCode;

    public Address(@JsonProperty("street") String street,
                   @JsonProperty("city") String city,
                   @JsonProperty("state") String state,
                   @JsonProperty("postalcode") Integer postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

}
