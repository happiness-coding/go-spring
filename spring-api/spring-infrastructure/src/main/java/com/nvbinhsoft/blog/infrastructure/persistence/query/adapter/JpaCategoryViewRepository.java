package com.nvbinhsoft.blog.infrastructure.persistence.query.adapter;

import com.nvbinhsoft.blog.infrastructure.persistence.query.entity.CategoryViewEntity;
import com.nvbinhsoft.blog.infrastructure.persistence.query.repository.SpringCategoryViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaCategoryViewRepository {

    private final SpringCategoryViewRepository springCategoryViewRepository;

    @Autowired
    public JpaCategoryViewRepository(SpringCategoryViewRepository springCategoryViewRepository) {
        this.springCategoryViewRepository = springCategoryViewRepository;
    }

    public List<CategoryViewEntity> findAll() {
        return springCategoryViewRepository.findAll();
    }
}
