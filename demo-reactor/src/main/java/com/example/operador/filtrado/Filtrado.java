package com.example.operador.filtrado;

import com.example.model.Persona;
import com.example.operador.creacion.Creacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {
    private static final Logger log = LoggerFactory.getLogger(Filtrado.class);

    public void filter(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 29));
        personas.add(new Persona(3, "Jean", 29));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 28)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinct(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 29));
        personas.add(new Persona(2, "Jean", 29));

        Flux.fromIterable(personas)
                .distinct(p -> p.getIdPersona())
                .subscribe(p -> log.info(p.toString()));
    }

    //toma los primeros elementos indicado por un numero
    public void take(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 29));
        personas.add(new Persona(2, "Jean", 29));

        Flux.fromIterable(personas)
                .take(2)
                .subscribe(p -> log.info(p.toString()));
    }

    //toma los ultimos elementos indicado por un numero
    public void takeLast(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 29));
        personas.add(new Persona(2, "Jean", 29));

        Flux.fromIterable(personas)
                .takeLast(2)
                .subscribe(p -> log.info(p.toString()));
    }

    //evita los primeros elementos indicado por un numero
    public void skip(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 29));
        personas.add(new Persona(2, "Jean", 29));

        Flux.fromIterable(personas)
                .skip(2)
                .subscribe(p -> log.info(p.toString()));
    }

    //evita los ultimos elementos indicado por un numero
    public void skipLast(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 29));
        personas.add(new Persona(2, "Jean", 29));

        Flux.fromIterable(personas)
                .skipLast(2)
                .subscribe(p -> log.info(p.toString()));
    }
}
