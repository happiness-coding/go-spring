package com.nvbinhsoft.blog.domain.model.common;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Embeddable
public class Email {

  @NotNull @Email private String email;

  public Email() {}

  public Email(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
