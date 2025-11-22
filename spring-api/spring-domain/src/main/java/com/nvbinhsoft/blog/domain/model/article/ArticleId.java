package com.nvbinhsoft.blog.domain.model.article;

import java.util.Objects;

public class ArticleId {

  private Long id;

  public ArticleId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ArticleId articleId = (ArticleId) o;
    return Objects.equals(id, articleId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "ArticleId{" + "id=" + id + '}';
  }
}
