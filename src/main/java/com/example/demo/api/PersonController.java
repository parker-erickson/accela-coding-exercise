package com.example.demo.api;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @PostMapping(path = "{id}")
    public int addAddressToPerson(@PathVariable("id") Integer id, @Valid @RequestBody Address address) {
        return personService.addAddressToPerson(id,
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode());
    }

    @PutMapping(path = "{id}")
    public int editAddress(@PathVariable("id") Integer id, @Valid @RequestBody Address address) {
        return personService.editAddress(id,
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode());
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "name/{firstname}_{lastname}")
    public Person getPersonByName(@PathVariable("firstname") String firstName, @PathVariable("lastname") String lastName){
        return personService.getPersonByName(firstName, lastName)
                .orElse(null);
    }

    @GetMapping(path = "id/{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @GetMapping(path = {"/count"})
    public int countPersons(){
        return personService.countPersons();
    }

    @DeleteMapping(path ="{id}")
    public int deletePerson(@PathVariable("id") Integer id) {
        return personService.deletePerson(id);
    }

    @DeleteMapping(path = {"delete-address_{id}"})
    public int deleteAddress(@PathVariable("id") Integer id) {
        return personService.deleteAddress(id);
    }
}
