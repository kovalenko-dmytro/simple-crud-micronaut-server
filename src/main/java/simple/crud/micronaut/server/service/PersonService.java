package simple.crud.micronaut.server.service;

import simple.crud.micronaut.server.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    /*Maybe<Person> findById(long personId);
    Single<Person> save(Person person);
    Single<Person> update(Person person);
    void delete(long personId);*/
}
