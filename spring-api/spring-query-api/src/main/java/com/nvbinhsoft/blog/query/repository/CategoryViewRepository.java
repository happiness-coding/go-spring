package com.nvbinhsoft.blog.query.repository;

import com.nvbinhsoft.blog.query.dto.CategoryView;

import java.util.List;

public interface CategoryViewRepository {

    List<CategoryView> findAll();
}
