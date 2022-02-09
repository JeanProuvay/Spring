package com.example.multithreading.controller;

import com.example.multithreading.entity.User;
import com.example.multithreading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value="/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
        for(MultipartFile file:files){
            service.saveUsers(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users", produces = "application/json")
    public CompletableFuture<ResponseEntity> findAllUsers(){
        return service.findAllUsers().thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/getUsersByThread", produces = "application/json")
    public ResponseEntity getUsers() throws ExecutionException, InterruptedException {
        CompletableFuture<List<User>> users1 = service.findAllUsers();
        CompletableFuture<List<User>> users2 = service.findAllUsers();
        CompletableFuture<List<User>> users3 = service.findAllUsers();
        CompletableFuture.allOf(users1,users2,users3).join();

        List<User> lista = users1.get();
        System.out.println(lista.get(1));

        //service.preApproved(); //hilo asyncrono ejecutandose sin esperar a que termine para terminar el servicio

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}



