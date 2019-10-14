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
import javax.transaction.Transactional;
import java.util.Optional;

@Singleton
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Inject
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Flowable<PersonDTO> findAll() {
        return personRepository.findAll().map(Person::convertToDTO);
    }

    @Override
    public Maybe<PersonDTO> findById(long personID) throws DomainNoFoundException {
        Person person = Optional
                .ofNullable(personRepository.findById(personID).blockingGet())
                .orElseThrow(() -> new DomainNoFoundException("no found"));
        return Maybe.just(person).map(Person::convertToDTO);
    }

    @Override
    public Single<PersonDTO> save(PersonDTO personDTO) {
        Person person = new Person();
        person.convertFromDTO(personDTO);
        return personRepository.save(person).map(Person::convertToDTO);
    }

    @Override
    public Single<PersonDTO> update(long personID, PersonDTO personDTO) throws DomainNoFoundException {
        Person person = Optional
                .ofNullable(personRepository.findById(personID).blockingGet())
                .orElseThrow(() -> new DomainNoFoundException("no found"));
        person.convertFromDTO(personDTO);
        personRepository.update(personID, person.getFirstName(), person.getLastName(), person.getEmail(), person.getBirthday());
        return findById(personID).toSingle();
    }

    @Override
    public void delete(long personID) throws DomainNoFoundException {
        Person person = Optional
                .ofNullable(personRepository.findById(personID).blockingGet())
                .orElseThrow(() -> new DomainNoFoundException("no found"));
        personRepository.delete(person).blockingAwait();
    }
}
