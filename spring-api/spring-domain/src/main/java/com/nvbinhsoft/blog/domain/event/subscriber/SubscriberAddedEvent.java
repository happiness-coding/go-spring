package com.nvbinhsoft.blog.domain.event.subscriber;

import com.nvbinhsoft.blog.domain.event.DomainEvent;

public class SubscriberAddedEvent implements DomainEvent {

  private final Long subscriberId;

  public SubscriberAddedEvent(Long subscriberId) {
    this.subscriberId = subscriberId;
  }

  public Long getSubscriberId() {
    return subscriberId;
  }

  @Override
  public String getEventType() {
    return "SubscriberAddedEvent";
  }
}
