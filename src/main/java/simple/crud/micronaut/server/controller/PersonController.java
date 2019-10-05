package simple.crud.micronaut.server.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.service.PersonService;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/persons")
@Validated
public class PersonController {

    private final PersonService personService;

    @Inject
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Get(value = "/")
    public Single<List<Person>> findAll() {
        return Single.just(personService.findAll());
    }
}
