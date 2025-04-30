package com.nvbinhsoft.blog.query.projector;

import com.nvbinhsoft.blog.domain.event.comment.CommentAddedEvent;
import com.nvbinhsoft.blog.domain.event.comment.CommentApprovedEvent;
import com.nvbinhsoft.blog.domain.model.comment.Comment;
import com.nvbinhsoft.blog.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentProjector {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentProjector(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void onCommentAdded(CommentAddedEvent event) {
        Comment comment = commentRepository.findById(event.getCommentId())
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        // Handle the logic for when a comment is added
        // For example, you might want to update some view model or cache
    }

    public void onCommentApproved(CommentApprovedEvent event) {
        Comment comment = commentRepository.findById(event.getCommentId())
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        // Handle the logic for when a comment is approved
        // For example, you might want to update some view model or cache
    }
}
