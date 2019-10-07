package simple.crud.micronaut.server.service;

import io.reactivex.Flowable;
import simple.crud.micronaut.server.entity.Person;

public interface PersonService {
    Flowable<Person> findAll();
    /*Maybe<Person> findById(long personId);
    Single<Person> save(Person person);
    Single<Person> update(Person person);
    void delete(long personId);*/
}
