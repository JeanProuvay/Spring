package com.example.theards;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class TheardsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TheardsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
        /* implementacion con herencia de clase Thread
        THilo thilo = new THilo(1);
        thilo.start();
        */

        /* implementacion con interfaz Runnable
        Thread rhilo = new Thread(new RHilo(2));
        rhilo.start();
        */

        /* implementacion con interfaz Callable, esta devuelve un valor y termina cuando terminan todos los hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> task1 = executor.submit(new CHilo());
        Future<?> task2 = executor.submit(new RHilo(2));

        while(!task1.isDone() && !task2.isDone()){

        }
        System.out.println(task1.get());
        System.out.println(task2.get());
        */

        /* ExecutorCompletionService permite recibir respuestas antes que terminen todos los hilos*/
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
        completionService.submit(new CHilo());
        completionService.submit(new CHilo());

        while(true){
            System.out.println(completionService.take().get());
        }


/*
        for(int i = 0; i<5; i++){
            System.out.println("Ejecutandose hilo MAIN ");

        }
 */
    }
}
