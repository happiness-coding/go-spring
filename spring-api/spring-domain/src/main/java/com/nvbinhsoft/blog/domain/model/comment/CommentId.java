package com.nvbinhsoft.blog.domain.model.comment;

import java.util.Objects;

public class CommentId {

  private Long id;

  public CommentId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CommentId commentId = (CommentId) o;
    return Objects.equals(id, commentId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "CommentId{" + "id=" + id + '}';
  }
}
