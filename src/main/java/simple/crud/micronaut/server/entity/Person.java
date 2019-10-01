package simple.crud.micronaut.server.entity;

import io.micronaut.core.annotation.Introspected;

import java.io.Serializable;
import java.time.LocalDate;

@Introspected
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private long personID;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;

    public Person(long personID, String firstName, String lastName, String email, LocalDate birthday) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
