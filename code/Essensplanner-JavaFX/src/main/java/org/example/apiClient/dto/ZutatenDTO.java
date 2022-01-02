package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.Objects;

public class ZutatenDTO implements Serializable {
    private Double amount;
    private String messart;
    private Long lebensmittelId;
    private String lebensmittelName;

    public ZutatenDTO(Double amount, String messart, Long lebensmittelId, String lebensmittelName) {
        this.amount = amount;
        this.messart = messart;
        this.lebensmittelId = lebensmittelId;
        this.lebensmittelName = lebensmittelName;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setMessart(String messart) {
        this.messart = messart;
    }

    public void setLebensmittelId(Long lebensmittelId) {
        this.lebensmittelId = lebensmittelId;
    }

    public void setLebensmittelName(String lebensmittelName) {
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
        ZutatenDTO entity = (ZutatenDTO) o;
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
