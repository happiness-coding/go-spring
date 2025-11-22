package com.nvbinhsoft.blog.domain.exception;

public class DomainException extends RuntimeException {

  private final String message;

  public DomainException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
