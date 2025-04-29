package com.nvbinhsoft.blog.domain.repository;

import com.nvbinhsoft.blog.domain.model.comment.Comment;
import com.nvbinhsoft.blog.domain.model.comment.CommentId;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);

    Optional<Comment> findById(CommentId commentId);

    List<Comment> findByArticleId(Long articleId);

    List<Comment> findAll();

    void deleteById(CommentId commentId);
}
