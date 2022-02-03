package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TagesplanResult implements Serializable {
     String idLocalDate;
     List<GerichteListeElementDto> gerichteListe;

    public TagesplanResult(String idLocalDate, List<GerichteListeElementDto> gerichteListe) {
        this.idLocalDate = idLocalDate;
        this.gerichteListe = gerichteListe;
    }

    public TagesplanResult() {
    }

    public void setIdLocalDate(String idLocalDate) {
        this.idLocalDate = idLocalDate;
    }

    public void setGerichteListe(List<GerichteListeElementDto> gerichteListe) {
        this.gerichteListe = gerichteListe;
    }

    public String getIdLocalDate() {
        return idLocalDate;
    }


    public List<GerichteListeElementDto> getGerichteListe() {
        return gerichteListe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagesplanResult entity = (TagesplanResult) o;
        return Objects.equals(this.idLocalDate, entity.idLocalDate) &&
                Objects.equals(this.gerichteListe, entity.gerichteListe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocalDate, gerichteListe);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idLocalDate = " + idLocalDate + ", " +
                "gerichteListe = " + gerichteListe + ")";
    }

    public static class GerichteListeElementDto implements Serializable {
         Long sequence;
         Long gerichtId;

        public GerichteListeElementDto() {
        }

        public GerichteListeElementDto(Long sequence, Long gerichtId) {
            this.sequence = sequence;
            this.gerichtId = gerichtId;
        }

        public void setSequence(Long sequence) {
            this.sequence = sequence;
        }

        public void setGerichtId(Long gerichtId) {
            this.gerichtId = gerichtId;
        }

        public Long getSequence() {
            return sequence;
        }

        public Long getGerichtId() {
            return gerichtId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GerichteListeElementDto entity = (GerichteListeElementDto) o;
            return Objects.equals(this.sequence, entity.sequence) &&
                    Objects.equals(this.gerichtId, entity.gerichtId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sequence, gerichtId);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "sequence = " + sequence + ", " +
                    "gerichtId = " + gerichtId + ")";
        }
    }
}
