package simple.crud.micronaut.server.service.impl;

import io.reactivex.Flowable;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.repository.PersonRepository;
import simple.crud.micronaut.server.service.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Inject
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Flowable<Person> findAll() {
        return personRepository.findAll();
    }

    /*@Override
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

    }*/
}
