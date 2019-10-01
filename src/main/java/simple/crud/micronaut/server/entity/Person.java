package simple.crud.micronaut.server.entity;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Introspected
@AllArgsConstructor
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private long personID;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
}
