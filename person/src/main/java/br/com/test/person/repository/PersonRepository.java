package br.com.test.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.test.person.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
