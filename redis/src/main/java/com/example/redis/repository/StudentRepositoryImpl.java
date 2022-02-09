package com.example.redis.repository;

import com.example.redis.config.CacheConfiguration;
import com.example.redis.domain.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements RedisRepository {

    private RedisTemplate<String, Student> redisTemplate;
    private HashOperations hashOperations;

    private static final String KEY = "Student";

    public StudentRepositoryImpl(
            RedisTemplate<String, Student> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Student> finAdll() {
        return hashOperations.entries(KEY);
    }

    @Cacheable(cacheNames = CacheConfiguration.STUDENTS_CACHE, unless = "#result == null")
    //@Cacheable("students")
    @Override
    public Student finById(String id) {
        try{Thread.sleep(3000);}catch (Exception e){}
        return (Student)hashOperations.get(KEY, id);
    }

    @CachePut(cacheNames = CacheConfiguration.STUDENTS_CACHE, key = "#id", unless = "#result == null")
    @Override
    public void save(Student student, String id) {
        hashOperations.put(KEY, id, student);
    }

    @CacheEvict(cacheNames = CacheConfiguration.STUDENTS_CACHE, key = "#id")
    //@CacheEvict("students")
    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
}


