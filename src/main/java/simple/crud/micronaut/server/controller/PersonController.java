package simple.crud.micronaut.server.controller;

import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import simple.crud.micronaut.server.dto.PersonDTO;
import simple.crud.micronaut.server.exception.DomainNoFoundException;
import simple.crud.micronaut.server.service.PersonService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller("/api/persons")
@Validated
@Transactional
public class PersonController {

    private final PersonService personService;

    @Inject
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Get
    public Flowable<PersonDTO> findAll() {
        return personService.findAll();
    }

    @Get(value = "/{personID}")
    public Maybe<PersonDTO> findByID(@PathVariable long personID) throws DomainNoFoundException {
        return personService.findById(personID);
    }

    @Post
    public Single<PersonDTO> create(@Valid @Body PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    @Put(value = "/{personID}")
    public Single<PersonDTO> update(@PathVariable long personID, @Valid @Body PersonDTO personDTO) throws DomainNoFoundException {
        return personService.update(personID, personDTO);
    }

    @Delete(value = "/{personID}")
    public void delete(@PathVariable long personID) throws DomainNoFoundException {
        personService.delete(personID);
    }
}
