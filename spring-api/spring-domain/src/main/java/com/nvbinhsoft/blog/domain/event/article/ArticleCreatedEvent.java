package com.nvbinhsoft.blog.domain.event.article;

import com.nvbinhsoft.blog.domain.event.DomainEvent;
import com.nvbinhsoft.blog.domain.model.article.ArticleId;

public class ArticleCreatedEvent implements DomainEvent {

  private final ArticleId articleId;

  public ArticleCreatedEvent(ArticleId articleId) {
    this.articleId = articleId;
  }

  public ArticleId getArticleId() {
    return articleId;
  }

  @Override
  public String getEventType() {
    return "ArticleCreatedEvent";
  }
}
