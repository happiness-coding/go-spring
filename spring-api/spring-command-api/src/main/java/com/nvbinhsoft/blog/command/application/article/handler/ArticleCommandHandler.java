package com.nvbinhsoft.blog.command.application.article.handler;

import com.nvbinhsoft.blog.command.application.article.command.CreateArticleCommand;
import com.nvbinhsoft.blog.command.application.article.command.DeleteArticleCommand;
import com.nvbinhsoft.blog.command.application.article.command.PublishArticleCommand;
import com.nvbinhsoft.blog.command.application.article.command.UpdateArticleCommand;
import com.nvbinhsoft.blog.domain.model.article.Article;
import com.nvbinhsoft.blog.domain.model.article.ArticleId;
import com.nvbinhsoft.blog.domain.model.article.ArticleStatus;
import com.nvbinhsoft.blog.domain.repository.ArticleRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleCommandHandler {

  private final ArticleRepository articleRepository;

  @Autowired
  public ArticleCommandHandler(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public void handleCreateArticle(CreateArticleCommand command) {
    Article article =
        new Article(
            command.getTitle(),
            command.getSlug(),
            command.getContent(),
            command.getExcerpt(),
            command.getFeaturedImageUrl(),
            new ArticleStatus(command.getStatus()),
            command.getCategoryId(),
            null,
            LocalDateTime.now(),
            LocalDateTime.now());
    articleRepository.save(article);
  }

  public void handleUpdateArticle(UpdateArticleCommand command) {
    Article article =
        articleRepository
            .findById(new ArticleId(command.getId()))
            .orElseThrow(() -> new RuntimeException("Article not found"));
    article.setTitle(command.getTitle());
    article.setSlug(command.getSlug());
    article.setContent(command.getContent());
    article.setExcerpt(command.getExcerpt());
    article.setFeaturedImageUrl(command.getFeaturedImageUrl());
    article.setStatus(new ArticleStatus(command.getStatus()));
    article.setCategoryId(command.getCategoryId());
    article.setUpdatedAt(LocalDateTime.now());
    articleRepository.save(article);
  }

  public void handleDeleteArticle(DeleteArticleCommand command) {
    Article article =
        articleRepository
            .findBySlug(command.getSlug())
            .orElseThrow(() -> new RuntimeException("Article not found"));
    articleRepository.deleteById(new ArticleId(article.getId()));
  }

  public void handlePublishArticle(PublishArticleCommand command) {
    Article article =
        articleRepository
            .findById(new ArticleId(command.getId()))
            .orElseThrow(() -> new RuntimeException("Article not found"));
    article.setStatus(new ArticleStatus("published"));
    article.setPublishedAt(LocalDateTime.now());
    articleRepository.save(article);
  }
}
