package com.nvbinhsoft.blog.infrastructure.persistence.query.repository;

import com.nvbinhsoft.blog.infrastructure.persistence.query.entity.ArticleViewEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringArticleViewRepository extends JpaRepository<ArticleViewEntity, Long> {

  List<ArticleViewEntity> findAllByCategoryId(Long categoryId);

  Optional<ArticleViewEntity> findBySlug(String slug);
}
