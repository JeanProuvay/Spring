package com.example.redis.repository;
/*
import com.example.redis.domain.Student;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;


@Repository
public class StudentRepositoryImp implements RedisRepository {

    private final Cache cache;

    public StudentRepositoryImp(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("students");
    }


    @Override
    public Map<String, Student> finAdll() {
        return null;
    }

    @Override
    public Student finById(String id) {
        Student student = (Student) Optional.ofNullable(cache.get(id)).orElse(()-> new Student());
        return student;
    }

    @Override
    public void save(Student student, String id) {
        cache.put(student, id);
    }

    @Override
    public void delete(String id) {
        cache.evict(id);
    }
}
 */

