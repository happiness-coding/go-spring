package com.nvbinhsoft.blog.infrastructure.persistence.query.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArticleViewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String slug;
  private String excerpt;
  private String featuredImageUrl;
  private LocalDateTime publishedAt;

  public ArticleViewEntity() {}

  public ArticleViewEntity(
      Long id,
      String title,
      String slug,
      String excerpt,
      String featuredImageUrl,
      LocalDateTime publishedAt) {
    this.id = id;
    this.title = title;
    this.slug = slug;
    this.excerpt = excerpt;
    this.featuredImageUrl = featuredImageUrl;
    this.publishedAt = publishedAt;
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
}
