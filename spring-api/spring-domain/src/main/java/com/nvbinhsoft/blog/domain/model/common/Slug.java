package com.nvbinhsoft.blog.domain.model.common;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Slug {

    private String slug;

    public Slug() {
    }

    public Slug(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slug slug1 = (Slug) o;
        return Objects.equals(slug, slug1.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug);
    }

    @Override
    public String toString() {
        return "Slug{" +
                "slug='" + slug + '\'' +
                '}';
    }
}
