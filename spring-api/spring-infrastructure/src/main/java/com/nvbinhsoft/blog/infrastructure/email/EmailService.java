package com.nvbinhsoft.blog.infrastructure.email;

public interface EmailService {

  void sendEmail(String to, String subject, String body);

  void sendSubscriptionEmail(String to, String subscriptionDetails);

  void sendNotificationEmail(String to, String notificationDetails);
}
