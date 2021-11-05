package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class Person {

    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private Address address;


    public Person(@JsonProperty("id") Integer id,
                  @JsonProperty("firstname") String firstName,
                  @JsonProperty("lastname") String lastName,
                  @JsonProperty("address") Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

}
