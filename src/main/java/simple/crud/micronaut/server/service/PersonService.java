package simple.crud.micronaut.server.service;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import simple.crud.micronaut.server.dto.PersonDTO;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.exception.DomainNoFoundException;

public interface PersonService {
    Flowable<Person> findAll();
    Maybe<Person> findById(long personID);
    Single<Person> save(PersonDTO personDTO);
    Single<Person> update(long personID, PersonDTO personDTO) throws DomainNoFoundException;
    void delete(long personID) throws DomainNoFoundException;
}
