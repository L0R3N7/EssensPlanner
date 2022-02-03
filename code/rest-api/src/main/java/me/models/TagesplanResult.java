package me.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TagesplanResult implements Serializable {
    private final String idLocalDate;
    private final List<GerichteListeElementDto> gerichteListe;

    public TagesplanResult(String idLocalDate, List<GerichteListeElementDto> gerichteListe) {
        this.idLocalDate = idLocalDate;
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
        private final Long sequence;
        private final Long gerichtId;

        public GerichteListeElementDto(Long sequence, Long gerichtId) {
            this.sequence = sequence;
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
