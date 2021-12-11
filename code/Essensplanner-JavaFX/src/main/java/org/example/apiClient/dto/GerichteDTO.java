package org.example.apiClient.dto;

public class GerichteDTO {
    String name;
    String desc;
    String imageUrl;
    Boolean fav;


    public GerichteDTO(String name, String desc, String imageUrl, Boolean fav) {
        this.name = name;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.fav = fav;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public GerichteDTO() {
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
