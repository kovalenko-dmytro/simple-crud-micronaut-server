package simple.crud.micronaut.server.repository;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import simple.crud.micronaut.server.entity.Person;

import java.util.List;

public interface PersonRepository {
    Flowable<List<Person>> findAll();
    Maybe<Person> findById(long personId);
    Single<Person> save(Person person);
    Single<Person> update(Person person);
    void delete(long personId);
}
