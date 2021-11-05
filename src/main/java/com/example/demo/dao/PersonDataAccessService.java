package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("PersonDao")
public class PersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(Person person) {
        DB.add(new Person(person.getId(), person.getFirstName(), person.getLastName(), person.getAddress()));
        return 1;
    }

    public Optional<Person> selectPersonByName(String firstName, String lastName){
        return DB.stream()
                .filter(person -> (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)))
                .findFirst();
    }

    public Optional<Person> selectPersonById(Integer id){
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int editPerson(Integer id, Person newPerson) {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if(indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id,
                                newPerson.getFirstName(),
                                newPerson.getLastName(),
                                newPerson.getAddress()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deletePerson(Integer id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int addAddressToPerson(Integer id, String street, String city, String state, Integer postalCode) {
        return changeAddress(id, street, city, state, postalCode);
    }

    @Override
    public int editAddress(Integer id, String street, String city, String state, Integer postalCode) {
        return changeAddress(id, street, city, state, postalCode);
    }

    // helper
    private int changeAddress(Integer id, String street, String city, String state, Integer postalCode) {
        Address address = new Address(street, city, state, postalCode);
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if(indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(person.getId(),
                                person.getFirstName(),
                                person.getLastName(),
                                address));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deleteAddress(Integer id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
            return personMaybe
                    .map(person -> {
                        int indexOfPersonToUpdate = DB.indexOf(person);
                        if (indexOfPersonToUpdate >= 0) {
                            DB.set(indexOfPersonToUpdate, new Person(person.getId(),
                                    person.getFirstName(),
                                    person.getLastName(),
                                    null));
                            return 1;
                        }
                        return 0;
                    })
                    .orElse(0);
    }

    @Override
    public int countPersons() {
        return DB.size();
    }

    @Override
    public List<Person> listPersons() {
        return DB;
    }

}
