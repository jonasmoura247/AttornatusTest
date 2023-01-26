package br.com.test.person.http.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.test.person.entity.Person;
import br.com.test.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person salvar(@RequestBody Person person) {
        return personService.salvar(person);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> listPerson() {
        return personService.listPerson();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person searchPersonForId(@PathVariable("id") Long id) {
        return personService.searchForId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente nao encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePerson(@PathVariable("id") Long id) {
        personService.searchForId(id)
                .map(person -> {
                    personService.removeForId(person.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        personService.searchForId(id)
                .map(personBase -> {
                    modelMapper.map(person, personBase);
                    personService.salvar(personBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

}


