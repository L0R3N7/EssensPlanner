package me.models;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class LebensmittelDTO implements Serializable {
    private final String name;

    public LebensmittelDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LebensmittelDTO entity = (LebensmittelDTO) o;
        return Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ")";
    }
}
