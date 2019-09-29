package simple.crud.micronaut.server.repository.person.impl;

import com.mongodb.reactivestreams.client.MongoCollection;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.repository.person.PersonRepository;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

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

    @Override
    public MongoCollection<Person> getCollection() {
        return null;
    }
}
