package com.nvbinhsoft.blog.query.application.article.handler;

import com.nvbinhsoft.blog.query.application.article.query.GetArticleQuery;
import com.nvbinhsoft.blog.query.application.article.query.GetArticlesByCategoryQuery;
import com.nvbinhsoft.blog.query.application.article.query.ListArticlesQuery;
import com.nvbinhsoft.blog.query.dto.ArticleDetailView;
import com.nvbinhsoft.blog.query.dto.ArticleView;
import com.nvbinhsoft.blog.query.repository.ArticleViewRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleQueryHandler {

  private final ArticleViewRepository articleViewRepository;

  @Autowired
  public ArticleQueryHandler(ArticleViewRepository articleViewRepository) {
    this.articleViewRepository = articleViewRepository;
  }

  public ArticleDetailView handleGetArticle(GetArticleQuery query) {
    return articleViewRepository
        .findBySlug(query.getSlug())
        .map(
            article ->
                new ArticleDetailView(
                    article.getId(),
                    article.getTitle(),
                    article.getSlug(),
                    article.getContent(),
                    article.getExcerpt(),
                    article.getFeaturedImageUrl(),
                    article.getPublishedAt(),
                    article.getCategory(),
                    article.getTags()))
        .orElseThrow(() -> new RuntimeException("Article not found"));
  }

  public List<ArticleView> handleListArticles(ListArticlesQuery query) {
    return articleViewRepository
        .findAll(query.getPage(), query.getSize(), query.getCategoryId(), query.getTag())
        .stream()
        .map(
            article ->
                new ArticleView(
                    article.getId(),
                    article.getTitle(),
                    article.getSlug(),
                    article.getExcerpt(),
                    article.getFeaturedImageUrl(),
                    article.getPublishedAt()))
        .collect(Collectors.toList());
  }

  public List<ArticleView> handleGetArticlesByCategory(GetArticlesByCategoryQuery query) {
    return articleViewRepository.findByCategoryId(query.getCategoryId()).stream()
        .map(
            article ->
                new ArticleView(
                    article.getId(),
                    article.getTitle(),
                    article.getSlug(),
                    article.getExcerpt(),
                    article.getFeaturedImageUrl(),
                    article.getPublishedAt()))
        .collect(Collectors.toList());
  }
}
