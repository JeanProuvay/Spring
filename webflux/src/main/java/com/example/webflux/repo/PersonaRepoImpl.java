package com.example.webflux.repo;

import com.example.webflux.controller.PersonaController;
import com.example.webflux.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepoImpl implements PersonaRepo{
    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Override
    public Mono<Persona> registrar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Mono<Persona> modificar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Flux<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jean",28));
        personas.add(new Persona(1,"Juan",29));
        personas.add(new Persona(1,"Jhon",30));
        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> listarPorId(Integer id) {
        return Mono.just(new Persona(1,"Jean",28));
    }

    @Override
    public Mono<Void> eliminar(Integer id) {
        return Mono.empty();
    }
}
