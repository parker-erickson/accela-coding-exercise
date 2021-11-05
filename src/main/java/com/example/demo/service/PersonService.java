package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("PersonDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    @PostMapping
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.listPersons();
    }

    public Optional<Person> getPersonByName(String firstName, String lastName) {
        return personDao.selectPersonByName(firstName, lastName);
    }

    public Optional<Person> getPersonById(Integer id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(Integer id) {
        return personDao.deletePerson(id);
    }

    public int editPerson(Integer id, Person newPerson) {
        return personDao.editPerson(id, newPerson);
    }

    public int addAddressToPerson(Integer id,
                                  String street,
                                  String city,
                                  String state,
                                  Integer postalCode){
        return personDao.addAddressToPerson(id, street, city, state, postalCode);
    }

    public int editAddress(Integer id,
                    String street,
                    String city,
                    String state,
                    Integer postalCode){
        return personDao.editAddress(id, street, city, state, postalCode);
    }

    public int deleteAddress(Integer id) {
        return personDao.deleteAddress(id);
    }

    public int countPersons(){
        return personDao.countPersons();
    }

}
