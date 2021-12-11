package org.example.apiClient.dto;

public class ZutatenlisteDTO {
    private double amount;
    private String messart;
    private String ZutatName;

    public ZutatenlisteDTO() {
    }

    public ZutatenlisteDTO(double amount, String messart, String zutatName) {
        this.amount = amount;
        this.messart = messart;
        ZutatName = zutatName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessart() {
        return messart;
    }

    public void setMessart(String messart) {
        this.messart = messart;
    }

    public String getZutatName() {
        return ZutatName;
    }

    public void setZutatName(String zutatName) {
        ZutatName = zutatName;
    }
}
