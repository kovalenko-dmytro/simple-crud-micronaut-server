package simple.crud.micronaut.server.repository;

import simple.crud.micronaut.server.entity.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAll();
}
