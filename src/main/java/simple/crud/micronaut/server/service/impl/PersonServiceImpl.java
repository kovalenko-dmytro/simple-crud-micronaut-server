package simple.crud.micronaut.server.service.impl;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Override
    public Flowable<List<Person>> findAll() {
        return null;
    }

    @Override
    public Maybe<Person> findById(long personId) {
        return null;
    }

    @Override
    public Single<Person> save(Person person) {
        return null;
    }

    @Override
    public Single<Person> update(Person person) {
        return null;
    }

    @Override
    public void delete(long personId) {

    }
}
