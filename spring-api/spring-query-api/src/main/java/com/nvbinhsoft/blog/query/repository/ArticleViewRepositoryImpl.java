package com.nvbinhsoft.blog.query.repository;

import com.nvbinhsoft.blog.query.dto.ArticleDetailView;
import com.nvbinhsoft.blog.query.dto.ArticleView;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleViewRepositoryImpl implements ArticleViewRepository {

  // Mock data for demonstration
  private static final List<ArticleView> ARTICLES = new ArrayList<>();
  private static final Map<String, ArticleDetailView> ARTICLE_DETAILS = new HashMap<>();

  static {
    // Example mock data
    ARTICLES.add(
        new ArticleView(1L, "first-article", "First Article", 1L, Arrays.asList("java", "spring")));
    ARTICLES.add(
        new ArticleView(
            2L, "second-article", "Second Article", 2L, Arrays.asList("spring", "api")));
    ARTICLES.add(
        new ArticleView(
            3L, "third-article", "Third Article", 1L, Arrays.asList("java", "backend")));

    ARTICLE_DETAILS.put(
        "first-article",
        new ArticleDetailView(
            1L,
            "first-article",
            "First Article",
            "Content of first article",
            1L,
            Arrays.asList("java", "spring")));
    ARTICLE_DETAILS.put(
        "second-article",
        new ArticleDetailView(
            2L,
            "second-article",
            "Second Article",
            "Content of second article",
            2L,
            Arrays.asList("spring", "api")));
    ARTICLE_DETAILS.put(
        "third-article",
        new ArticleDetailView(
            3L,
            "third-article",
            "Third Article",
            "Content of third article",
            1L,
            Arrays.asList("java", "backend")));
  }

  @Override
  public List<ArticleView> findAll(int page, int size, Long categoryId, String tag) {
    return ARTICLES.stream()
        .filter(a -> (categoryId == null || a.getCategoryId().equals(categoryId)))
        .filter(a -> (tag == null || a.getTags().contains(tag)))
        .skip((long) page * size)
        .limit(size)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<ArticleDetailView> findBySlug(String slug) {
    return Optional.ofNullable(ARTICLE_DETAILS.get(slug));
  }

  @Override
  public List<ArticleView> findByCategoryId(Long categoryId) {
    return ARTICLES.stream()
        .filter(a -> a.getCategoryId().equals(categoryId))
        .collect(Collectors.toList());
  }
}
