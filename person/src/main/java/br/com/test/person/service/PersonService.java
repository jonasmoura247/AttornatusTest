package br.com.test.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.test.person.entity.Person;
import br.com.test.person.repository.PersonRepository;

@Service

public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person salvar(Person person) {
        return personRepository.save(person);
    }

    public List<Person> listPerson() {
        return personRepository.findAll();

    }

    public Optional<Person> searchForId(Long id) {
        return personRepository.findById(id);
    }

    public void removeForId(Long id){
        personRepository.deleteById(id);
    }

}
