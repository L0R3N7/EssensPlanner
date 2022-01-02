package me.workloads.zutaten;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ZutatenDto implements Serializable {
    private final Double amount;
    private final String messart;
    private final Long lebensmittelId;
    @NotNull
    private final String lebensmittelName;

    public ZutatenDto(Double amount, String messart, Long lebensmittelId, String lebensmittelName) {
        this.amount = amount;
        this.messart = messart;
        this.lebensmittelId = lebensmittelId;
        this.lebensmittelName = lebensmittelName;
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

    public String getLebensmittelName() {
        return lebensmittelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZutatenDto entity = (ZutatenDto) o;
        return Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.messart, entity.messart) &&
                Objects.equals(this.lebensmittelId, entity.lebensmittelId) &&
                Objects.equals(this.lebensmittelName, entity.lebensmittelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, messart, lebensmittelId, lebensmittelName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "amount = " + amount + ", " +
                "messart = " + messart + ", " +
                "lebensmittelId = " + lebensmittelId + ", " +
                "lebensmittelName = " + lebensmittelName + ")";
    }
}
