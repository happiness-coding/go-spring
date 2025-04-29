package com.nvbinhsoft.blog.domain.exception;

import com.nvbinhsoft.blog.domain.model.article.ArticleId;

public class ArticleNotFoundException extends DomainException {

    private final ArticleId articleId;

    public ArticleNotFoundException(ArticleId articleId) {
        super("Article not found with ID: " + articleId.getId());
        this.articleId = articleId;
    }

    public ArticleId getArticleId() {
        return articleId;
    }
}
