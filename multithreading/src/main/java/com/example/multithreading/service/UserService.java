package com.example.multithreading.service;

import com.example.multithreading.entity.User;
import com.example.multithreading.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    Object target;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Async
    public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception {
        long start=System.currentTimeMillis();
        List<User> users = parseCSVFile(file);
        logger.info("saving list of users of size {}", users.size(),""+Thread.currentThread().getName());
        users=repository.saveAll(users);
        long end=System.currentTimeMillis();
        logger.info("Total time {}",(end-start));
        return CompletableFuture.completedFuture(users);
    }

    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        logger.info("get list of user by "+ Thread.currentThread().getName());
        List<User> users = repository.findAll();
        return CompletableFuture.completedFuture(users);
    }

    private List<User> parseCSVFile(final MultipartFile file) throws Exception{
        final List<User> users = new ArrayList<>();
        try{
            try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                String line;
                while((line=br.readLine()) != null){
                    final String[] data = line.split(",");
                    final User user= new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
                return users;
            }
        }catch (final IOException e){
            logger.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }
/*
    public CompletableFuture<List<User>> findAllUsers2(){
        CompletableFuture<List<User>> call1 = CompletableFuture.supplyAsync(new Supplier<List<User>>() {
            @Override
            public List<User> get() {
                logger.info("get list of user by "+ Thread.currentThread().getName());
                List<User> users = repository.findAll();
                return users;
            }
        });
        CompletableFuture.allOf(call1).join();
        return call1;
    }
 */



    /* Implementacion donde se ejecuta el hilo y se continua con el servicio sin esperar a que este termine
    @Async()
    public Future<Void> preApproved() {
        Runnable runnable = () -> {
            //Logica que se ejecutara en hilo
        };
        return CompletableFuture.runAsync(runnable);
    }

     */
}
