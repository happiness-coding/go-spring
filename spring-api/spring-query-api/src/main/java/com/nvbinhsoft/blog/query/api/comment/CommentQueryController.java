package com.nvbinhsoft.blog.query.api.comment;

import com.nvbinhsoft.blog.query.application.comment.handler.CommentQueryHandler;
import com.nvbinhsoft.blog.query.dto.CommentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentQueryController {

    private final CommentQueryHandler commentQueryHandler;

    @Autowired
    public CommentQueryController(CommentQueryHandler commentQueryHandler) {
        this.commentQueryHandler = commentQueryHandler;
    }

    @GetMapping("/articles/{articleId}/comments")
    public List<CommentView> getCommentsByArticle(@PathVariable Long articleId) {
        return commentQueryHandler.handleGetCommentsByArticle(articleId);
    }
}
