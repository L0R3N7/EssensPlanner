package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.Objects;

public class RezeptDTO implements Serializable {
    private final Long idId;
    private final String content;

    public RezeptDTO(Long idId, String content) {
        this.idId = idId;
        this.content = content;
    }

    public Long getIdId() {
        return idId;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezeptDTO entity = (RezeptDTO) o;
        return Objects.equals(this.idId, entity.idId) &&
                Objects.equals(this.content, entity.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idId, content);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idId = " + idId + ", " +
                "content = " + content + ")";
    }
}
