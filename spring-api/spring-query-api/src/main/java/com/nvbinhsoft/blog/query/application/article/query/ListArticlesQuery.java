package com.nvbinhsoft.blog.query.application.article.query;

public class ListArticlesQuery {

  private int page;
  private int size;
  private Long categoryId;
  private String tag;

  public ListArticlesQuery(int page, int size, Long categoryId, String tag) {
    this.page = page;
    this.size = size;
    this.categoryId = categoryId;
    this.tag = tag;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }
}
