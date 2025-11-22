package com.nvbinhsoft.blog.infrastructure.email.smtp;

import com.nvbinhsoft.blog.infrastructure.email.EmailService;
import com.nvbinhsoft.blog.infrastructure.email.template.NotificationTemplate;
import com.nvbinhsoft.blog.infrastructure.email.template.SubscriptionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService implements EmailService {

  private final JavaMailSender mailSender;
  private final SubscriptionTemplate subscriptionTemplate;
  private final NotificationTemplate notificationTemplate;

  @Value("${spring.mail.username}")
  private String fromEmail;

  @Autowired
  public SmtpEmailService(
      JavaMailSender mailSender,
      SubscriptionTemplate subscriptionTemplate,
      NotificationTemplate notificationTemplate) {
    this.mailSender = mailSender;
    this.subscriptionTemplate = subscriptionTemplate;
    this.notificationTemplate = notificationTemplate;
  }

  @Override
  public void sendEmail(String to, String subject, String body) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(fromEmail);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(body);
    mailSender.send(message);
  }

  @Override
  public void sendSubscriptionEmail(String to, String subscriptionDetails) {
    String subject = "Subscription Confirmation";
    String body = subscriptionTemplate.getSubscriptionEmailTemplate(subscriptionDetails);
    sendEmail(to, subject, body);
  }

  @Override
  public void sendNotificationEmail(String to, String notificationDetails) {
    String subject = "New Notification";
    String body = notificationTemplate.getNotificationEmailTemplate(notificationDetails);
    sendEmail(to, subject, body);
  }
}
