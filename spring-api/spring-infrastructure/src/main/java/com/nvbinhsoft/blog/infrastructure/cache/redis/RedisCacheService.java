package com.nvbinhsoft.blog.infrastructure.cache.redis;

import com.nvbinhsoft.blog.infrastructure.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService implements CacheService {

  private final RedisTemplate<String, Object> redisTemplate;

  @Autowired
  public RedisCacheService(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public void put(String key, Object value) {
    redisTemplate.opsForValue().set(key, value);
  }

  @Override
  public Object get(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  @Override
  public void evict(String key) {
    redisTemplate.delete(key);
  }

  @Override
  public void clear() {
    redisTemplate.getConnectionFactory().getConnection().flushDb();
  }
}
