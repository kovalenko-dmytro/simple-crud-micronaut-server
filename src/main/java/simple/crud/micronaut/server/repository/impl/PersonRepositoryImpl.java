package simple.crud.micronaut.server.repository.impl;


import io.reactiverse.reactivex.pgclient.PgPool;
import io.reactiverse.reactivex.pgclient.PgStream;
import io.reactiverse.reactivex.pgclient.Row;
import io.reactiverse.reactivex.pgclient.Tuple;
import io.reactivex.Flowable;
import simple.crud.micronaut.server.entity.Person;
import simple.crud.micronaut.server.repository.PersonRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonRepositoryImpl implements PersonRepository {

    private static final String FIND_ALL ="SELECT person_id, first_name, last_name, email, birthday FROM public.persons";

    private final PgPool client;

    @Inject
    public PersonRepositoryImpl(PgPool client) {
        this.client = client;
    }

    @Override
    public Flowable<Person> findAll() {
        return client
                .rxBegin()
                .flatMapPublisher(tx -> tx.rxPrepare(FIND_ALL)
                        .flatMapPublisher(preparedQuery -> {
                            PgStream<Row> stream = preparedQuery.createStream(100, Tuple.tuple());
                            return stream.toFlowable();
                        })
                        .map(row -> Person.builder()
                                .personID(row.getInteger("person_id"))
                                .firstName(row.getString("first_name"))
                                .lastName(row.getString("last_name"))
                                .email(row.getString("email"))
                                .birthday(row.getLocalDate("birthday"))
                                .build())
                        .doAfterTerminate(tx::commit));
    }
}
