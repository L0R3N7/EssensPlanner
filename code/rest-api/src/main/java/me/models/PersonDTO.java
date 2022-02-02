package me.models;

import me.workloads.person.Person;

import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable {
    private String email;
    private String password;
    private String[] uniqueSessionCode;

    public PersonDTO(String email, String password, String[] uniqueSessionCode) {
        this.email = email;
        this.password = password;
        this.uniqueSessionCode = uniqueSessionCode;
    }

    public PersonDTO() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUniqueSessionCode(String[] uniqueSessionCode) {
        this.uniqueSessionCode = uniqueSessionCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String[] getUniqueSessionCode() {
        return uniqueSessionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO entity = (PersonDTO) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.uniqueSessionCode, entity.uniqueSessionCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, uniqueSessionCode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "uniqueSessionCode = " + uniqueSessionCode + ")";
    }
}
