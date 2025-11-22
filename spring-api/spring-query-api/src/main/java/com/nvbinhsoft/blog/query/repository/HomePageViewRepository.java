package com.nvbinhsoft.blog.query.repository;

import com.nvbinhsoft.blog.query.dto.ArticleView;
import com.nvbinhsoft.blog.query.dto.CategoryView;
import java.util.List;

public interface HomePageViewRepository {

  List<ArticleView> findFeaturedArticles();

  List<ArticleView> findRecentArticles();

  List<CategoryView> findCategories();
}
