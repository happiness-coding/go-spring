package com.nvbinhsoft.blog.domain.event.comment;

import com.nvbinhsoft.blog.domain.event.DomainEvent;
import com.nvbinhsoft.blog.domain.model.comment.CommentId;

public class CommentAddedEvent implements DomainEvent {

    private final CommentId commentId;

    public CommentAddedEvent(CommentId commentId) {
        this.commentId = commentId;
    }

    public CommentId getCommentId() {
        return commentId;
    }

    @Override
    public String getEventType() {
        return "COMMENT_ADDED";
    }
}
