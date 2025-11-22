package com.nvbinhsoft.blog.domain.model.common;

import javax.persistence.*;

@MappedSuperclass
public abstract class AggregateRoot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public AggregateRoot() {}

  public AggregateRoot(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
