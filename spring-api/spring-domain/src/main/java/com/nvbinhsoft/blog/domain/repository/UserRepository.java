package com.nvbinhsoft.blog.domain.repository;

import com.nvbinhsoft.blog.domain.model.user.User;
import com.nvbinhsoft.blog.domain.model.user.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(UserId userId);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    void deleteById(UserId userId);
}
