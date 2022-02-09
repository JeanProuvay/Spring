package com.example.redis.repository;

import com.example.redis.domain.Student;

import java.util.Map;

public interface RedisRepository {
    Map<String, Student> finAdll();
    Student finById(String id);
    void save(Student student, String id);
    void delete(String id);
}
