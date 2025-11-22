package com.nvbinhsoft.blog.infrastructure.email.template;

public class SubscriptionTemplate {

  public String getSubscriptionEmailTemplate(String subscriptionDetails) {
    return "<html>"
        + "<body>"
        + "<h1>Subscription Confirmation</h1>"
        + "<p>Thank you for subscribing to our blog!</p>"
        + "<p>"
        + subscriptionDetails
        + "</p>"
        + "</body>"
        + "</html>";
  }
}
