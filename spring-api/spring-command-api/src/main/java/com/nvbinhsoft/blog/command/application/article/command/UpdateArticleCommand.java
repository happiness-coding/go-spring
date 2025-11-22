package com.nvbinhsoft.blog.command.application.article.command;

import java.util.List;

public class UpdateArticleCommand {

  private Long id;
  private String title;
  private String slug;
  private String content;
  private String excerpt;
  private String featuredImageUrl;
  private String status;
  private Long categoryId;
  private List<String> tags;

  public UpdateArticleCommand(
      Long id,
      String title,
      String slug,
      String content,
      String excerpt,
      String featuredImageUrl,
      String status,
      Long categoryId,
      List<String> tags) {
    this.id = id;
    this.title = title;
    this.slug = slug;
    this.content = content;
    this.excerpt = excerpt;
    this.featuredImageUrl = featuredImageUrl;
    this.status = status;
    this.categoryId = categoryId;
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }
}
