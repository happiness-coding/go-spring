package com.nvbinhsoft.blog.infrastructure.email.template;

public class NotificationTemplate {

  public String getNotificationEmailTemplate(String notificationDetails) {
    return "<html>"
        + "<body>"
        + "<h1>Notification</h1>"
        + "<p>You have a new notification:</p>"
        + "<p>"
        + notificationDetails
        + "</p>"
        + "</body>"
        + "</html>";
  }
}
