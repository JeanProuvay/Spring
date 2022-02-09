package com.example.springboot.reactor.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<String> usuariosList = new ArrayList<>();
        usuariosList.add("Jean Prouvay");
        usuariosList.add("Jhon Smith");
        usuariosList.add("Juan Hernandez");

        Flux<String> nombres = Flux.fromIterable(usuariosList);
        //Flux<String> nombres = Flux.just("Jean Prouvay","Jhon Smith","Juan Hernandez");
            Flux<Usuario> usuarios = nombres
            .map(nombreCompleto -> {
                return new Usuario(
                        nombreCompleto.split(" ")[0].toUpperCase(),
                        nombreCompleto.split(" ")[1].toUpperCase()
                );
            })
            .filter(usuario -> usuario.getNombre().toLowerCase().equals("jean"))
            .doOnNext(usuario -> {
                if(usuario == null){
                    throw new RuntimeException("Nombres no pueden ser vacios");
                }
                System.out.println(usuario.getNombre());
            })
            .map(usuario -> {
                usuario.setNombre(usuario.getNombre().toLowerCase());
                return usuario;
            });

        usuarios.subscribe(
            elemento -> log.info(elemento.toString()),
            error -> log.error(error.getMessage()),
            new Runnable() {
                @Override
                public void run() {
                    log.info("Ha finalizado la ejecucion del observable con exito!");
                }
            }
        );
    }
}
