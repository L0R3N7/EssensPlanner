package me.models;

import java.io.Serializable;
import java.util.Objects;

public class RezeptDTO implements Serializable {
    private final String content;

    public RezeptDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezeptDTO entity = (RezeptDTO) o;
        return Objects.equals(this.content, entity.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "content = " + content + ")";
    }
}
