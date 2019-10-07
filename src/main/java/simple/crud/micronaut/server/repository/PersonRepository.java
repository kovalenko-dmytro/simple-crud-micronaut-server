package simple.crud.micronaut.server.repository;

import io.reactivex.Flowable;
import simple.crud.micronaut.server.entity.Person;

public interface PersonRepository {
    Flowable<Person> findAll();
}
