package com.nvbinhsoft.blog.domain.exception;

public class InvalidSlugException extends RuntimeException {

  private final String slug;

  public InvalidSlugException(String slug) {
    this.slug = slug;
  }

  public String getSlug() {
    return slug;
  }
}
