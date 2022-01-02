package org.example.apiClient.dto;

import java.io.Serializable;
import java.util.Objects;

public class GerichtDTO implements Serializable {
    private String ImageUrl;
    private String Name;

    public GerichtDTO( String imageUrl, String name) {
        ImageUrl = imageUrl;
        Name = name;
    }

    public GerichtDTO() {
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public void setName(String name) {
        Name = name;
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
        return Objects.equals(this.ImageUrl, entity.ImageUrl) &&
                Objects.equals(this.Name, entity.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ImageUrl, Name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "ImageUrl = " + ImageUrl + ", " +
                "Name = " + Name + ")";
    }
}
