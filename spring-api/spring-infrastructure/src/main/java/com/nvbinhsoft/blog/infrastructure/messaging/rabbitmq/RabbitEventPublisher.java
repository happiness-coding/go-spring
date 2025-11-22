package com.nvbinhsoft.blog.infrastructure.messaging.rabbitmq;

import com.nvbinhsoft.blog.domain.event.DomainEvent;
import com.nvbinhsoft.blog.domain.event.article.ArticleCreatedEvent;
import com.nvbinhsoft.blog.domain.event.article.ArticlePublishedEvent;
import com.nvbinhsoft.blog.domain.event.article.ArticleUpdatedEvent;
import com.nvbinhsoft.blog.domain.event.comment.CommentAddedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitEventPublisher {

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public RabbitEventPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publishEvent(DomainEvent event) {
    if (event instanceof ArticleCreatedEvent) {
      rabbitTemplate.convertAndSend("blogQueue", event);
    } else if (event instanceof ArticlePublishedEvent) {
      rabbitTemplate.convertAndSend("blogQueue", event);
    } else if (event instanceof ArticleUpdatedEvent) {
      rabbitTemplate.convertAndSend("blogQueue", event);
    } else if (event instanceof CommentAddedEvent) {
      rabbitTemplate.convertAndSend("blogQueue", event);
    }
  }
}
