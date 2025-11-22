package com.nvbinhsoft.blog.infrastructure.persistence.command.repository;

import com.nvbinhsoft.blog.domain.model.article.Article;
import com.nvbinhsoft.blog.domain.model.article.ArticleId;
import com.nvbinhsoft.blog.domain.model.common.Slug;
import com.nvbinhsoft.blog.domain.repository.ArticleRepository;
import com.nvbinhsoft.blog.infrastructure.persistence.command.entity.ArticleEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringArticleRepository implements ArticleRepository {

  @PersistenceContext private EntityManager entityManager;

  @Autowired
  public SpringArticleRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Article save(Article article) {
    ArticleEntity articleEntity =
        new ArticleEntity(
            article.getTitle(),
            article.getSlug().getValue(),
            article.getContent(),
            article.getExcerpt(),
            article.getFeaturedImageUrl(),
            article.getStatus().getValue(),
            article.getCategoryId(),
            article.getPublishedAt(),
            article.getCreatedAt(),
            article.getUpdatedAt());
    entityManager.persist(articleEntity);
    return article;
  }

  @Override
  public Optional<Article> findById(ArticleId articleId) {
    ArticleEntity articleEntity = entityManager.find(ArticleEntity.class, articleId.getValue());
    return Optional.ofNullable(articleEntity).map(this::mapToDomain);
  }

  @Override
  public Optional<Article> findBySlug(Slug slug) {
    ArticleEntity articleEntity =
        entityManager
            .createQuery("SELECT a FROM ArticleEntity a WHERE a.slug = :slug", ArticleEntity.class)
            .setParameter("slug", slug.getValue())
            .getSingleResult();
    return Optional.ofNullable(articleEntity).map(this::mapToDomain);
  }

  @Override
  public List<Article> findAll() {
    List<ArticleEntity> articleEntities =
        entityManager
            .createQuery("SELECT a FROM ArticleEntity a", ArticleEntity.class)
            .getResultList();
    return articleEntities.stream().map(this::mapToDomain).collect(Collectors.toList());
  }

  @Override
  public void deleteById(ArticleId articleId) {
    ArticleEntity articleEntity = entityManager.find(ArticleEntity.class, articleId.getValue());
    if (articleEntity != null) {
      entityManager.remove(articleEntity);
    }
  }

  private Article mapToDomain(ArticleEntity articleEntity) {
    return new Article(
        articleEntity.getId(),
        articleEntity.getTitle(),
        new Slug(articleEntity.getSlug()),
        articleEntity.getContent(),
        articleEntity.getExcerpt(),
        articleEntity.getFeaturedImageUrl(),
        new ArticleStatus(articleEntity.getStatus()),
        articleEntity.getCategoryId(),
        articleEntity.getPublishedAt(),
        articleEntity.getCreatedAt(),
        articleEntity.getUpdatedAt());
  }
}
