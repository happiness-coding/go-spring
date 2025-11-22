package com.nvbinhsoft.blog.domain.repository;

import com.nvbinhsoft.blog.domain.model.article.Article;
import com.nvbinhsoft.blog.domain.model.article.ArticleId;
import com.nvbinhsoft.blog.domain.model.common.Slug;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

  Article save(Article article);

  Optional<Article> findById(ArticleId articleId);

  Optional<Article> findBySlug(Slug slug);

  List<Article> findAll();

  void deleteById(ArticleId articleId);
}
