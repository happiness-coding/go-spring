package com.nvbinhsoft.blog.query.api.tag;

import com.nvbinhsoft.blog.query.application.tag.handler.TagQueryHandler;
import com.nvbinhsoft.blog.query.dto.TagView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagQueryController {

  private final TagQueryHandler tagQueryHandler;

  @Autowired
  public TagQueryController(TagQueryHandler tagQueryHandler) {
    this.tagQueryHandler = tagQueryHandler;
  }

  @GetMapping
  public List<TagView> getAllTags() {
    return tagQueryHandler.handleGetAllTags();
  }
}
