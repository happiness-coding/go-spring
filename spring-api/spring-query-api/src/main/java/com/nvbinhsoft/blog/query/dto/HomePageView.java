package com.nvbinhsoft.blog.query.dto;

import java.util.List;

public class HomePageView {

  private List<ArticleView> featuredArticles;
  private List<ArticleView> recentArticles;
  private List<CategoryView> categories;

  public HomePageView(
      List<ArticleView> featuredArticles,
      List<ArticleView> recentArticles,
      List<CategoryView> categories) {
    this.featuredArticles = featuredArticles;
    this.recentArticles = recentArticles;
    this.categories = categories;
  }

  public List<ArticleView> getFeaturedArticles() {
    return featuredArticles;
  }

  public void setFeaturedArticles(List<ArticleView> featuredArticles) {
    this.featuredArticles = featuredArticles;
  }

  public List<ArticleView> getRecentArticles() {
    return recentArticles;
  }

  public void setRecentArticles(List<ArticleView> recentArticles) {
    this.recentArticles = recentArticles;
  }

  public List<CategoryView> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryView> categories) {
    this.categories = categories;
  }
}
