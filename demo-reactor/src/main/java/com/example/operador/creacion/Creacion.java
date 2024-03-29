package com.example.operador.creacion;

import com.example.DemoReactorApplication;
import com.example.model.Persona;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void justFrom(){
        Mono.just(new Persona(1, "Mito", 29));
        //Flux.fromIterable(coleccion);
        //Observable.just(new Persona(1, "Mito", 29));
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range(){
        Flux.range(0,3)
                .doOnNext(i -> log.info("i: "+i))
                .subscribe();
    }

    public void repeat(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(3, "Jean", 28));

        Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));
    }
}
