package me.models;

import java.io.Serializable;
import java.util.Objects;

public class ZutatenDTO implements Serializable {
    private final Double amount;
    private final String messart;

    public ZutatenDTO(Double amount, String messart) {
        this.amount = amount;
        this.messart = messart;
    }

    public Double getAmount() {
        return amount;
    }

    public String getMessart() {
        return messart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZutatenDTO entity = (ZutatenDTO) o;
        return Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.messart, entity.messart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, messart);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "amount = " + amount + ", " +
                "messart = " + messart + ")";
    }
}
