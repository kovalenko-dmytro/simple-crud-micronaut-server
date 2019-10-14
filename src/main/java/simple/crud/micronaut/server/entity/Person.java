package simple.crud.micronaut.server.entity;

import io.micronaut.core.convert.format.Format;
import lombok.Data;
import lombok.NoArgsConstructor;
import simple.crud.micronaut.server.dto.PersonDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long personID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    @Format("yyyy-MM-dd")
    private LocalDate birthday;

    public void convertFromDTO(PersonDTO personDTO) {
        this.firstName = personDTO.getFirstName();
        this.lastName = personDTO.getLastName();
        this.email = personDTO.getEmail();
        this.birthday = LocalDate.parse(personDTO.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public PersonDTO convertToDTO() {
        PersonDTO dto = new PersonDTO();
        dto.setPersonID(personID);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setBirthday(birthday.toString());
        return dto;
    }
}
