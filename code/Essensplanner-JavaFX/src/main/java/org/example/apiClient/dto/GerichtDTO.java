package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.Objects;

public class GerichtDTO implements Serializable {
    private Long id;
    private String ImageUrl;
    private String Name;

    public GerichtDTO(Long id, String imageUrl, String name) {
        this.id = id;
        ImageUrl = imageUrl;
        Name = name;
    }

    public GerichtDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GerichtDTO entity = (GerichtDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.ImageUrl, entity.ImageUrl) &&
                Objects.equals(this.Name, entity.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ImageUrl, Name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "ImageUrl = " + ImageUrl + ", " +
                "Name = " + Name + ")";
    }
}
