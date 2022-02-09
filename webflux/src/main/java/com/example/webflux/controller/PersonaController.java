package com.example.webflux.controller;

import com.example.webflux.model.Persona;
import com.example.webflux.repo.PersonaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private PersonaRepo repo;

    @GetMapping
    public Flux<Persona> listar(){
        return repo.listar();
    }

    @GetMapping("/{id}")
    public Mono<Persona> listarPorId(@PathVariable("id") Integer id){
        return repo.listarPorId(id);
    }

    @PostMapping
    public Mono<Persona> registrar(@RequestBody Persona persona){
        return repo.registrar(persona);
    }

    @PutMapping
    public Mono<Persona> modificar(@RequestBody Persona persona){
        return repo.modificar(persona);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable("id") Integer id){
        return repo.listarPorId(id)
                .flatMap(p -> repo.eliminar(p.getIdPersona()));
    }
}
