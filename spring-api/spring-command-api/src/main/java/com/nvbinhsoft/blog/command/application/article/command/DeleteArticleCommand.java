package com.nvbinhsoft.blog.command.application.article.command;

public class DeleteArticleCommand {

    private String slug;

    public DeleteArticleCommand(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
