package com.nvbinhsoft.blog.command.api.article;

import com.nvbinhsoft.blog.command.application.article.command.CreateArticleCommand;
import com.nvbinhsoft.blog.command.application.article.command.DeleteArticleCommand;
import com.nvbinhsoft.blog.command.application.article.command.PublishArticleCommand;
import com.nvbinhsoft.blog.command.application.article.command.UpdateArticleCommand;
import com.nvbinhsoft.blog.command.application.article.handler.ArticleCommandHandler;
import com.nvbinhsoft.blog.command.dto.request.CreateArticleRequest;
import com.nvbinhsoft.blog.command.dto.request.UpdateArticleRequest;
import com.nvbinhsoft.blog.command.dto.response.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleCommandController {

    private final ArticleCommandHandler articleCommandHandler;

    @Autowired
    public ArticleCommandController(ArticleCommandHandler articleCommandHandler) {
        this.articleCommandHandler = articleCommandHandler;
    }

    @PostMapping
    public ResponseEntity<CommandResponse> createArticle(@RequestBody CreateArticleRequest request) {
        CreateArticleCommand command = new CreateArticleCommand(
                request.getTitle(),
                request.getSlug(),
                request.getContent(),
                request.getExcerpt(),
                request.getFeaturedImageUrl(),
                request.getStatus(),
                request.getCategoryId(),
                request.getTags()
        );
        articleCommandHandler.handleCreateArticle(command);
        return new ResponseEntity<>(new CommandResponse(true, "Article created successfully", null), HttpStatus.CREATED);
    }

    @PutMapping("/{slug}")
    public ResponseEntity<CommandResponse> updateArticle(@PathVariable String slug, @RequestBody UpdateArticleRequest request) {
        UpdateArticleCommand command = new UpdateArticleCommand(
                request.getId(),
                request.getTitle(),
                request.getSlug(),
                request.getContent(),
                request.getExcerpt(),
                request.getFeaturedImageUrl(),
                request.getStatus(),
                request.getCategoryId(),
                request.getTags()
        );
        articleCommandHandler.handleUpdateArticle(command);
        return new ResponseEntity<>(new CommandResponse(true, "Article updated successfully", null), HttpStatus.OK);
    }

    @DeleteMapping("/{slug}")
    public ResponseEntity<CommandResponse> deleteArticle(@PathVariable String slug) {
        DeleteArticleCommand command = new DeleteArticleCommand(slug);
        articleCommandHandler.handleDeleteArticle(command);
        return new ResponseEntity<>(new CommandResponse(true, "Article deleted successfully", null), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{articleId}/publish")
    public ResponseEntity<CommandResponse> publishArticle(@PathVariable Long articleId) {
        PublishArticleCommand command = new PublishArticleCommand(articleId);
        articleCommandHandler.handlePublishArticle(command);
        return new ResponseEntity<>(new CommandResponse(true, "Article published successfully", null), HttpStatus.OK);
    }
}
