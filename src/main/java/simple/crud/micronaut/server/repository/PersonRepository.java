package simple.crud.micronaut.server.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.RxJavaCrudRepository;
import simple.crud.micronaut.server.entity.Person;

@Repository
public interface PersonRepository extends RxJavaCrudRepository<Person, Long> {

}
