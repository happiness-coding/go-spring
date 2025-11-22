package com.nvbinhsoft.blog.infrastructure.persistence.query.adapter;

import com.nvbinhsoft.blog.infrastructure.persistence.query.entity.ArticleViewEntity;
import com.nvbinhsoft.blog.infrastructure.persistence.query.repository.SpringArticleViewRepository;
import com.nvbinhsoft.blog.query.dto.ArticleDetailView;
import com.nvbinhsoft.blog.query.dto.ArticleView;
import com.nvbinhsoft.blog.query.repository.ArticleViewRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaArticleViewRepository implements ArticleViewRepository {

  private final SpringArticleViewRepository springArticleViewRepository;

  @Autowired
  public JpaArticleViewRepository(SpringArticleViewRepository springArticleViewRepository) {
    this.springArticleViewRepository = springArticleViewRepository;
  }

  @Override
  public List<ArticleView> findAll(int page, int size, Long categoryId, String tag) {
    return springArticleViewRepository.findAll().stream()
        .map(this::mapToArticleView)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<ArticleDetailView> findBySlug(String slug) {
    return springArticleViewRepository.findBySlug(slug).map(this::mapToArticleDetailView);
  }

  @Override
  public List<ArticleView> findByCategoryId(Long categoryId) {
    return springArticleViewRepository.findAllByCategoryId(categoryId).stream()
        .map(this::mapToArticleView)
        .collect(Collectors.toList());
  }

  private ArticleView mapToArticleView(ArticleViewEntity entity) {
    return new ArticleView(
        entity.getId(),
        entity.getTitle(),
        entity.getSlug(),
        entity.getExcerpt(),
        entity.getFeaturedImageUrl(),
        entity.getPublishedAt());
  }

  private ArticleDetailView mapToArticleDetailView(ArticleViewEntity entity) {
    return new ArticleDetailView(
        entity.getId(),
        entity.getTitle(),
        entity.getSlug(),
        entity.getExcerpt(),
        entity.getFeaturedImageUrl(),
        entity.getPublishedAt(),
        null,
        null);
  }
}
