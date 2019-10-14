package simple.crud.micronaut.server.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.RxJavaCrudRepository;
import simple.crud.micronaut.server.entity.Person;

import java.time.LocalDate;

@Repository
public interface PersonRepository extends RxJavaCrudRepository<Person, Long> {
    @Query(value = "update Person p set p.firstName = :firstName, p.lastName = :lastName, p.email = :email, p.birthday = :birthday  where p.personID = :personID",
            nativeQuery = true)
    void update(long personID, String firstName, String lastName, String email, LocalDate birthday);
}
