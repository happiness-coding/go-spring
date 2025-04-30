package com.nvbinhsoft.blog.command.application.article.command;

public class PublishArticleCommand {

    private Long id;

    public PublishArticleCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
