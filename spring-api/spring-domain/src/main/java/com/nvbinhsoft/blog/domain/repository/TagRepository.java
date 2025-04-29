package com.nvbinhsoft.blog.domain.repository;

import com.nvbinhsoft.blog.domain.model.tag.Tag;
import com.nvbinhsoft.blog.domain.model.tag.TagId;
import com.nvbinhsoft.blog.domain.model.common.Slug;

import java.util.List;
import java.util.Optional;

public interface TagRepository {

    Tag save(Tag tag);

    Optional<Tag> findById(TagId tagId);

    Optional<Tag> findBySlug(Slug slug);

    List<Tag> findAll();

    void deleteById(TagId tagId);
}
