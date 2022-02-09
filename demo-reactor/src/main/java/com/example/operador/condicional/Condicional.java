package com.example.operador.condicional;

import com.example.DemoReactorApplication;
import com.example.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Condicional {
    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void defaultIfEmpty(){
        Mono.empty()
                .defaultIfEmpty(new Persona(0, "DEFAULT", 99))
                .subscribe(x -> log.info(x.toString()));
    }
    //Se ejecuta hasta que se cumpla la condicion
    public void takeUntil(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 27));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(3, "Jean", 26));

        Flux.fromIterable(personas)
                .takeUntil(p -> p.getEdad() > 27)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeout() throws InterruptedException {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 27));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(3, "Jean", 26));

        Flux.fromIterable(personas)
                .delayElements(Duration.ofSeconds(3))//lanzara un delay en responder del tiempo especificado
                .timeout(Duration.ofSeconds(2))//lanzara una excepcion de tipo timeout despues del tiepo especificado
                .subscribe(x -> log.info(x.toString()));
        Thread.sleep(30000);//el hilo principal esperara los milisegundos indicados antes de terminar
    }
}
