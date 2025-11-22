package com.nvbinhsoft.blog.infrastructure.messaging.kafka;

import com.nvbinhsoft.blog.domain.event.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventPublisher {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public KafkaEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void publishEvent(DomainEvent event) {
    kafkaTemplate.send("topic1", event.getEventType(), event.toString());
  }
}
