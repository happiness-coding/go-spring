package com.nvbinhsoft.blog.domain.event.comment;

import com.nvbinhsoft.blog.domain.event.DomainEvent;
import com.nvbinhsoft.blog.domain.model.comment.CommentId;

public class CommentApprovedEvent implements DomainEvent {

    private final CommentId commentId;

    public CommentApprovedEvent(CommentId commentId) {
        this.commentId = commentId;
    }

    public CommentId getCommentId() {
        return commentId;
    }

    @Override
    public String getEventType() {
        return "COMMENT_APPROVED";
    }
}
