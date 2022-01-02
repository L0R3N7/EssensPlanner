package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.Objects;


public class PersonDTO implements Serializable {
    private String email;
    private String password;
    private byte[] uniqueSessionCode;

    public PersonDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public PersonDTO() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUniqueSessionCode(byte[] uniqueSessionCode) {
        this.uniqueSessionCode = uniqueSessionCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getUniqueSessionCode() {
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
