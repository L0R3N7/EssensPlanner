package me.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TagesplanDTOo implements Serializable {
    private String idLocalDate;
    private List<GerichteListeElementDto> gerichteListe;

    public TagesplanDTOo(String idLocalDate, List<GerichteListeElementDto> gerichteListe) {
        this.idLocalDate = idLocalDate;
        this.gerichteListe = gerichteListe;
    }

    public TagesplanDTOo() {
    }

    public String getIdLocalDate() {
        return idLocalDate;
    }

    public List<GerichteListeElementDto> getGerichteListe() {
        return gerichteListe;
    }

    public void setIdLocalDate(String idLocalDate) {
        this.idLocalDate = idLocalDate;
    }

    public void setGerichteListe(List<GerichteListeElementDto> gerichteListe) {
        this.gerichteListe = gerichteListe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagesplanDTOo entity = (TagesplanDTOo) o;
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
        private Long id;
        private Long sequence;
        private Long gerichtId;

        public GerichteListeElementDto(Long id, Long sequence, Long gerichtId) {
            this.id = id;
            this.sequence = sequence;
            this.gerichtId = gerichtId;
        }

        public GerichteListeElementDto() {
        }

        public Long getId() {
            return id;
        }

        public Long getSequence() {
            return sequence;
        }

        public Long getGerichtId() {
            return gerichtId;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setSequence(Long sequence) {
            this.sequence = sequence;
        }

        public void setGerichtId(Long gerichtId) {
            this.gerichtId = gerichtId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GerichteListeElementDto entity = (GerichteListeElementDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.sequence, entity.sequence) &&
                    Objects.equals(this.gerichtId, entity.gerichtId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, sequence, gerichtId);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "sequence = " + sequence + ", " +
                    "gerichtId = " + gerichtId + ")";
        }
    }
}
