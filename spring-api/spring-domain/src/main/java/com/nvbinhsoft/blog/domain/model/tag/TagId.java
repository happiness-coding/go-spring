package com.nvbinhsoft.blog.domain.model.tag;

import java.util.Objects;

public class TagId {

  private Long id;

  public TagId(Long id) {
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
    TagId tagId = (TagId) o;
    return Objects.equals(id, tagId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "TagId{" + "id=" + id + '}';
  }
}
