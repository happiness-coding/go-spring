package com.nvbinhsoft.blog.infrastructure.persistence.command.repository;

import com.nvbinhsoft.blog.domain.model.category.Category;
import com.nvbinhsoft.blog.domain.model.category.CategoryId;
import com.nvbinhsoft.blog.domain.model.common.Slug;
import com.nvbinhsoft.blog.domain.repository.CategoryRepository;
import com.nvbinhsoft.blog.infrastructure.persistence.command.entity.CategoryEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringCategoryRepository implements CategoryRepository {

  @PersistenceContext private EntityManager entityManager;

  @Autowired
  public SpringCategoryRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Category save(Category category) {
    CategoryEntity categoryEntity =
        new CategoryEntity(
            category.getName(), category.getSlug().getValue(), category.getDescription());
    entityManager.persist(categoryEntity);
    return category;
  }

  @Override
  public Optional<Category> findById(CategoryId categoryId) {
    CategoryEntity categoryEntity = entityManager.find(CategoryEntity.class, categoryId.getValue());
    return Optional.ofNullable(categoryEntity).map(this::mapToDomain);
  }

  @Override
  public Optional<Category> findBySlug(Slug slug) {
    CategoryEntity categoryEntity =
        entityManager
            .createQuery(
                "SELECT c FROM CategoryEntity c WHERE c.slug = :slug", CategoryEntity.class)
            .setParameter("slug", slug.getValue())
            .getSingleResult();
    return Optional.ofNullable(categoryEntity).map(this::mapToDomain);
  }

  @Override
  public List<Category> findAll() {
    List<CategoryEntity> categoryEntities =
        entityManager
            .createQuery("SELECT c FROM CategoryEntity c", CategoryEntity.class)
            .getResultList();
    return categoryEntities.stream().map(this::mapToDomain).collect(Collectors.toList());
  }

  @Override
  public void deleteById(CategoryId categoryId) {
    CategoryEntity categoryEntity = entityManager.find(CategoryEntity.class, categoryId.getValue());
    if (categoryEntity != null) {
      entityManager.remove(categoryEntity);
    }
  }

  private Category mapToDomain(CategoryEntity categoryEntity) {
    return new Category(
        categoryEntity.getId(),
        categoryEntity.getName(),
        new Slug(categoryEntity.getSlug()),
        categoryEntity.getDescription());
  }
}
