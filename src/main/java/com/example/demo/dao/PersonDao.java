package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.model.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    // Allows us to insert person with a given id
    int insertPerson(Person person);

    // Select person by id
    Optional<Person> selectPersonByName(String firstName, String lastName);

    // Edit person
    int editPerson(Integer id, Person person);

    // Delete person
    int deletePerson(Integer id);

    // Add address to person
    int addAddressToPerson(Integer id,
                           String street,
                           String city,
                           String state,
                           Integer postalCode);


    // Edit address
    int editAddress(Integer id,
                    String street,
                    String city,
                    String state,
                    Integer postalCode);


    // Delete address
    int deleteAddress(Integer id);

    // Count number of persons
    int countPersons();

    // List persons
    List<Person> listPersons();


    Optional<Person> selectPersonById(Integer id);
}

