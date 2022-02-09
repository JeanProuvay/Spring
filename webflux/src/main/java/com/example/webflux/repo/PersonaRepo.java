package com.example.webflux.repo;

import com.example.webflux.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepo {
    Mono<Persona> registrar(Persona persona);
    Mono<Persona> modificar(Persona persona);
    Flux<Persona> listar();
    Mono<Persona> listarPorId(Integer id);
    Mono<Void> eliminar(Integer id);
}
