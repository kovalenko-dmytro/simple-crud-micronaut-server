package simple.crud.micronaut.server.entity;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.convert.format.Format;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Introspected
@Builder
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private long personID;
    private String firstName;
    private String lastName;
    private String email;
    @Format("yyyy-mm-dd")
    private LocalDate birthday;
}
