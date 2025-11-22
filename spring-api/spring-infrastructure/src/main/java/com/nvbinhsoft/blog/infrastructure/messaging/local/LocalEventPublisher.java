package com.nvbinhsoft.blog.infrastructure.messaging.local;

import com.nvbinhsoft.blog.domain.event.DomainEvent;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LocalEventPublisher {

  private final List<DomainEvent> events = new ArrayList<>();

  public void publish(DomainEvent event) {
    events.add(event);
  }

  public List<DomainEvent> getPublishedEvents() {
    return new ArrayList<>(events);
  }
}
