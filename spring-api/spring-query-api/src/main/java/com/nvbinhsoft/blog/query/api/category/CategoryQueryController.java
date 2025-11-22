package com.nvbinhsoft.blog.query.api.category;

import com.nvbinhsoft.blog.query.application.category.handler.CategoryQueryHandler;
import com.nvbinhsoft.blog.query.dto.CategoryView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryQueryController {

  private final CategoryQueryHandler categoryQueryHandler;

  @Autowired
  public CategoryQueryController(CategoryQueryHandler categoryQueryHandler) {
    this.categoryQueryHandler = categoryQueryHandler;
  }

  @GetMapping
  public List<CategoryView> getAllCategories() {
    return categoryQueryHandler.handleGetAllCategories();
  }
}
