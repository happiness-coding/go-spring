package com.nvbinhsoft.blog.query.application.article.query;

public class GetArticlesByCategoryQuery {

  private Long categoryId;

  public GetArticlesByCategoryQuery(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }
}
