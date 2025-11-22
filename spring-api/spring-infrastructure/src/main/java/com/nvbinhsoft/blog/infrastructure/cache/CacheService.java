package com.nvbinhsoft.blog.infrastructure.cache;

public interface CacheService {

  void put(String key, Object value);

  Object get(String key);

  void evict(String key);

  void clear();
}
