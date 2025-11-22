package com.nvbinhsoft.blog.query.model;

import java.util.List;

public class HomePageViewModel {

  private List<ArticleViewModel> featuredArticles;
  private List<ArticleViewModel> recentArticles;
  private List<CategoryViewModel> categories;

  public HomePageViewModel(
      List<ArticleViewModel> featuredArticles,
      List<ArticleViewModel> recentArticles,
      List<CategoryViewModel> categories) {
    this.featuredArticles = featuredArticles;
    this.recentArticles = recentArticles;
    this.categories = categories;
  }

  public List<ArticleViewModel> getFeaturedArticles() {
    return featuredArticles;
  }

  public void setFeaturedArticles(List<ArticleViewModel> featuredArticles) {
    this.featuredArticles = featuredArticles;
  }

  public List<ArticleViewModel> getRecentArticles() {
    return recentArticles;
  }

  public void setRecentArticles(List<ArticleViewModel> recentArticles) {
    this.recentArticles = recentArticles;
  }

  public List<CategoryViewModel> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryViewModel> categories) {
    this.categories = categories;
  }
}
