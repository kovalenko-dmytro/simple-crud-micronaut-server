package simple.crud.micronaut.server.repository.impl;


import io.reactiverse.reactivex.pgclient.PgPool;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.repository.PersonRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PersonRepositoryImpl implements PersonRepository {

    private static final String FIND_ALL ="SELECT person_id, first_name, last_name, email, birthday FROM public.persons";

    private final PgPool client;

    @Inject
    public PersonRepositoryImpl(PgPool client) {
        this.client = client;
    }

    @Override
    public List<Person> findAll() {

        return client.rxPreparedQuery(FIND_ALL).map(rowSet -> {
            List<Person> persons = new ArrayList<>();
            rowSet.forEach(row -> {
                Person person = Person.builder()
                        .personID(row.getInteger("person_id"))
                        .firstName(row.getString("first_name"))
                        .lastName(row.getString("last_name"))
                        .email(row.getString("email"))
                        .birthday(row.getLocalDate("birthday"))
                        .build();
                persons.add(person);
            });
            return persons;
        }).blockingGet();
    }
}
