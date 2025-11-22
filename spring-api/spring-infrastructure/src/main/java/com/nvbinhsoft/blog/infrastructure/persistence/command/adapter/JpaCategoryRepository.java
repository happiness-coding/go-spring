package com.nvbinhsoft.blog.infrastructure.persistence.command.adapter;

import com.nvbinhsoft.blog.infrastructure.persistence.command.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {}
