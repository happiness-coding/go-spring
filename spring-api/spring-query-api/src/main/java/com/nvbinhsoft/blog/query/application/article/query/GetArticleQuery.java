package com.nvbinhsoft.blog.query.application.article.query;

public class GetArticleQuery {

  private String slug;

  public GetArticleQuery(String slug) {
    this.slug = slug;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }
}
