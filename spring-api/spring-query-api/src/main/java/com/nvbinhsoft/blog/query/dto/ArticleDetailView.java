package com.nvbinhsoft.blog.query.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleDetailView {

    private Long id;
    private String title;
    private String slug;
    private String content;
    private String excerpt;
    private String featuredImageUrl;
    private LocalDateTime publishedAt;
    private String category;
    private List<String> tags;

    public ArticleDetailView(Long id, String title, String slug, String content, String excerpt, String featuredImageUrl, LocalDateTime publishedAt, String category, List<String> tags) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.excerpt = excerpt;
        this.featuredImageUrl = featuredImageUrl;
        this.publishedAt = publishedAt;
        this.category = category;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public void setFeaturedImageUrl(String featuredImageUrl) {
        this.featuredImageUrl = featuredImageUrl;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
