package org.example.apiClient.dto;

public class GerichteDTO {
    long uniqueId;
    String name;
    String desc;
    String imageUrl;
    Boolean fav;

    public GerichteDTO(long uniqueId, String name, String desc, String imageUrl, Boolean fav) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.fav = fav;
    }
    public GerichteDTO() {
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }
}
