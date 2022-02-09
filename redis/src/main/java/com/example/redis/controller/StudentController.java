package com.example.redis.controller;

import com.example.redis.domain.Student;
//import com.example.redis.repository.StudentRepositoryImp;
import com.example.redis.repository.StudentRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.Map;

@RestController
public class StudentController {
    private StudentRepositoryImpl studentRepository;

    public StudentController(StudentRepositoryImpl studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("students")
    public ResponseEntity<Map<String, Student>> findAll(){
        return new ResponseEntity<>(studentRepository.finAdll(), HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<Student> findById(@PathVariable String id){
        return new ResponseEntity<>(studentRepository.finById(id), HttpStatus.OK);
    }

    @PostMapping("students")
    public ResponseEntity<Void> createStudent(@RequestBody Student student){
        String id = UUID.randomUUID().toString();
        System.out.println(id);
        studentRepository.save(student, id);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        studentRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
