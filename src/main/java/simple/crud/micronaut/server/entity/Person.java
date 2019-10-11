package simple.crud.micronaut.server.entity;

import io.micronaut.core.convert.format.Format;
import lombok.Data;
import simple.crud.micronaut.server.dto.PersonDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "persons")
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private long personID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    @Format("yyyy-mm-dd")
    private LocalDate birthday;

    public Person updateFromDTO(PersonDTO personDTO) {
        firstName = personDTO.getFirstName();
        lastName = personDTO.getLastName();
        email = personDTO.getEmail();
        birthday = LocalDate.parse(personDTO.getBirthday(), DateTimeFormatter.ofPattern("yyyy-mm-dd"));
        return this;
    }
}
