package org.example.apiClient.dto;

public class RezeptDTO {
    private int reihenfolge;
    private String desc;

    public RezeptDTO() {
    }

    public RezeptDTO(int reihenfolge, String desc) {
        this.reihenfolge = reihenfolge;
        this.desc = desc;
    }

    public int getReihenfolge() {
        return reihenfolge;
    }

    public void setReihenfolge(int reihenfolge) {
        this.reihenfolge = reihenfolge;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
