package org.example.apiClient.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TagesplanDTO implements Serializable {
    private String idPersonEmail;
    private String[] idPersonUniqueSessionCode;
    private String idLocalDate;
    private List<Long> gerichtListIds;

    public TagesplanDTO(String idPersonEmail, String[] idPersonUniqueSessionCode, String idLocalDate, List<Long> gerichtListIds) {
        this.idPersonEmail = idPersonEmail;
        this.idPersonUniqueSessionCode = idPersonUniqueSessionCode;
        this.idLocalDate = idLocalDate;
        this.gerichtListIds = gerichtListIds;
    }

    public TagesplanDTO() {

    }

    public String getIdPersonEmail() {
        return idPersonEmail;
    }

    public String[] getIdPersonUniqueSessionCode() {
        return idPersonUniqueSessionCode;
    }

    public String getIdLocalDate() {
        return idLocalDate;
    }

    public List<Long> getGerichtListIds() {
        return gerichtListIds;
    }

    public void setIdPersonEmail(String idPersonEmail) {
        this.idPersonEmail = idPersonEmail;
    }

    public void setIdPersonUniqueSessionCode(String[] idPersonUniqueSessionCode) {
        this.idPersonUniqueSessionCode = idPersonUniqueSessionCode;
    }

    public void setIdLocalDate(String idLocalDate) {
        this.idLocalDate = idLocalDate;
    }

    public void setGerichtListIds(List<Long> gerichtListIds) {
        this.gerichtListIds = gerichtListIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagesplanDTO entity = (TagesplanDTO) o;
        return Objects.equals(this.idPersonEmail, entity.idPersonEmail) &&
                Objects.equals(this.idPersonUniqueSessionCode, entity.idPersonUniqueSessionCode) &&
                Objects.equals(this.idLocalDate, entity.idLocalDate) &&
                Objects.equals(this.gerichtListIds, entity.gerichtListIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonEmail, idPersonUniqueSessionCode, idLocalDate, gerichtListIds);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idPersonEmail = " + idPersonEmail + ", " +
                "idPersonUniqueSessionCode = " + idPersonUniqueSessionCode + ", " +
                "idLocalDate = " + idLocalDate + ", " +
                "gerichtListIds = " + gerichtListIds + ")";
    }
}
