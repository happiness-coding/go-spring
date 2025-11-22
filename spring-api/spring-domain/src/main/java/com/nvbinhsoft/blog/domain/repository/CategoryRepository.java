package com.nvbinhsoft.blog.domain.repository;

import com.nvbinhsoft.blog.domain.model.category.Category;
import com.nvbinhsoft.blog.domain.model.category.CategoryId;
import com.nvbinhsoft.blog.domain.model.common.Slug;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

  Category save(Category category);

  Optional<Category> findById(CategoryId categoryId);

  Optional<Category> findBySlug(Slug slug);

  List<Category> findAll();

  void deleteById(CategoryId categoryId);
}
