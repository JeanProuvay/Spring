package com.example.operador.transformacion;

import com.example.model.Persona;
import com.example.operador.creacion.Creacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {
    private static final Logger log = LoggerFactory.getLogger(Transformacion.class);

    public void map(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(3, "Jean", 28));
        /*
        Flux.fromIterable(personas)
                .map(p -> {
                    p.setEdad(p.getEdad()+10);
                    return p;
                })
                .subscribe(p -> log.info(p.toString()));

        */
        Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> log.info("x: "+x));
    }

    public void flatMap(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(3, "Jean", 28));

        Flux.fromIterable(personas)
                .flatMap(p -> {
                    p.setEdad(p.getEdad()+10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void groupBy(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(2, "Jean", 28));

        Flux.fromIterable(personas)
                //.groupBy(p -> p.getIdPersona())
                .groupBy(Persona::getIdPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }
}
