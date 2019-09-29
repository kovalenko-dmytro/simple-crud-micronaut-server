package simple.crud.micronaut.server.repository;

import com.mongodb.reactivestreams.client.MongoCollection;
import simple.crud.micronaut.server.entity.Person;

public interface CommonRepository {
    MongoCollection<Person> getCollection();
}
