package me.models;

import java.io.Serializable;
import java.util.Objects;

public class ZutatenDTO implements Serializable {
    private final Double amount;
    private final String messart;
    private final Long lebensmittelId;

    public ZutatenDTO(Double amount, String messart, Long lebensmittelId) {
        this.amount = amount;
        this.messart = messart;
        this.lebensmittelId = lebensmittelId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getMessart() {
        return messart;
    }

    public Long getLebensmittelId() {
        return lebensmittelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZutatenDTO entity = (ZutatenDTO) o;
        return Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.messart, entity.messart) &&
                Objects.equals(this.lebensmittelId, entity.lebensmittelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, messart, lebensmittelId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "amount = " + amount + ", " +
                "messart = " + messart + ", " +
                "lebensmittelId = " + lebensmittelId + ")";
    }
}
