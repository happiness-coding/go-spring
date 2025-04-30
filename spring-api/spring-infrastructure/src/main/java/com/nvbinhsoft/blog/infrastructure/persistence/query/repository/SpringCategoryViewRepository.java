package com.nvbinhsoft.blog.infrastructure.persistence.query.repository;

import com.nvbinhsoft.blog.infrastructure.persistence.query.entity.CategoryViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCategoryViewRepository extends JpaRepository<CategoryViewEntity, Long> {
}
