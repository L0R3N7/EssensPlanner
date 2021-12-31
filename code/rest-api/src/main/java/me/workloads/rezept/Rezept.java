package me.workloads.rezept;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Rezept {
    @EmbeddedId
    RezeptId id;
    String content;

    public Rezept() {
    }

    public RezeptId getId() {
        return id;
    }

    public void setId(RezeptId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
