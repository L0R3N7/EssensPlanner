package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TagesplanDTO implements Serializable {
    private final Date idDate;

    public TagesplanDTO(Date idDate) {
        this.idDate = idDate;
    }

    public Date getIdDate() {
        return idDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagesplanDTO entity = (TagesplanDTO) o;
        return Objects.equals(this.idDate, entity.idDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idDate = " + idDate + ")";
    }
}
