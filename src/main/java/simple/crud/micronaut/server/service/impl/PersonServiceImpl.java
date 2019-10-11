package simple.crud.micronaut.server.service.impl;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import simple.crud.micronaut.server.dto.PersonDTO;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.exception.DomainNoFoundException;
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

    @Override
    public Maybe<Person> findById(long personId) {
        return personRepository.findById(personId);
    }

    @Override
    public Single<Person> save(PersonDTO personDTO) {
        Person person = new Person().updateFromDTO(personDTO);
        return personRepository.save(person);
    }

    @Override
    public Single<Person> update(long personID, PersonDTO personDTO) throws DomainNoFoundException {
        Person person = personRepository.findById(personID).blockingGet();
        if (person == null) {
            throw new DomainNoFoundException("no found");
        }
        return personRepository.save(person.updateFromDTO(personDTO));
    }

    @Override
    public void delete(long personID) throws DomainNoFoundException {
        Person person = personRepository.findById(personID).blockingGet();
        if (person == null) {
            throw new DomainNoFoundException("no found");
        }
        personRepository.delete(person);
    }
}
