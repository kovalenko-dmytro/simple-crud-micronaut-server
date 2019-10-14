package simple.crud.micronaut.server.service;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import simple.crud.micronaut.server.dto.PersonDTO;
import simple.crud.micronaut.server.exception.DomainNoFoundException;

public interface PersonService {
    Flowable<PersonDTO> findAll();
    Maybe<PersonDTO> findById(long personID) throws DomainNoFoundException;
    Single<PersonDTO> save(PersonDTO personDTO);
    Single<PersonDTO> update(long personID, PersonDTO personDTO) throws DomainNoFoundException;
    void delete(long personID) throws DomainNoFoundException;
}
