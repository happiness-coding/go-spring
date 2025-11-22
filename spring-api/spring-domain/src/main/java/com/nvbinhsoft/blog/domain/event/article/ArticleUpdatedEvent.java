package com.nvbinhsoft.blog.domain.event.article;

import com.nvbinhsoft.blog.domain.event.DomainEvent;
import com.nvbinhsoft.blog.domain.model.article.ArticleId;

public class ArticleUpdatedEvent implements DomainEvent {

  private final ArticleId articleId;

  public ArticleUpdatedEvent(ArticleId articleId) {
    this.articleId = articleId;
  }

  public ArticleId getArticleId() {
    return articleId;
  }

  @Override
  public String getEventType() {
    return "ArticleUpdatedEvent";
  }
}
