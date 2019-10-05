package simple.crud.micronaut.server.service.impl;

import io.reactivex.Single;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.repository.PersonRepository;
import simple.crud.micronaut.server.service.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Inject
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return Single.just(personRepository.findAll()).blockingGet();
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
