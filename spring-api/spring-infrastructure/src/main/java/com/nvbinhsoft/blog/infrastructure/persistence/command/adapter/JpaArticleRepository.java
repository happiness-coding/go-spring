package com.nvbinhsoft.blog.infrastructure.persistence.command.adapter;

import com.nvbinhsoft.blog.infrastructure.persistence.command.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaArticleRepository extends JpaRepository<ArticleEntity, Long> {}
