package simple.crud.micronaut.server.dto;

import io.micronaut.validation.Validated;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
@Data
public class PersonDTO {

    private long personID;
    @NotBlank
    @Size(max = 30)
    private String firstName;
    @NotBlank
    @Size(max = 50)
    private String lastName;
    @NotBlank
    @Email
    @Size(max = 100)
    private String email;
    @NotBlank
    private String birthday;
}
