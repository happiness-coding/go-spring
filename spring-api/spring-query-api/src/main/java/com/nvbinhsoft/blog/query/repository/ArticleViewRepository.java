package com.nvbinhsoft.blog.query.repository;

import com.nvbinhsoft.blog.query.dto.ArticleDetailView;
import com.nvbinhsoft.blog.query.dto.ArticleView;
import java.util.List;
import java.util.Optional;

public interface ArticleViewRepository {

  List<ArticleView> findAll(int page, int size, Long categoryId, String tag);

  Optional<ArticleDetailView> findBySlug(String slug);

  List<ArticleView> findByCategoryId(Long categoryId);
}
