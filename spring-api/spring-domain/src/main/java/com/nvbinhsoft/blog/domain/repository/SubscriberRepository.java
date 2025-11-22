package com.nvbinhsoft.blog.domain.repository;

import com.nvbinhsoft.blog.domain.model.common.Email;
import com.nvbinhsoft.blog.domain.model.user.User;
import java.util.List;
import java.util.Optional;

public interface SubscriberRepository {

  User save(User user);

  Optional<User> findById(Long id);

  Optional<User> findByEmail(Email email);

  List<User> findAll();

  void deleteById(Long id);
}
