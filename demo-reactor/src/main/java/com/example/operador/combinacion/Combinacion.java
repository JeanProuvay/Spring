package com.example.operador.combinacion;

import com.example.model.Persona;
import com.example.model.Venta;
import com.example.operador.filtrado.Filtrado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {
    private static final Logger log = LoggerFactory.getLogger(Filtrado.class);

    public void merge(){
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Jean", 27));
        personas1.add(new Persona(2, "Jean", 28));
        personas1.add(new Persona(3, "Jean", 29));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "Jean", 30));
        personas2.add(new Persona(5, "Jean", 31));
        personas2.add(new Persona(6, "Jean", 32));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx1, fx2, fx3)
                .subscribe(p -> log.info(p.toString()));
    }

    public void zip(){
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Jean", 27));
        personas1.add(new Persona(2, "Jean", 28));
        personas1.add(new Persona(3, "Jean", 29));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "Jean", 30));
        personas2.add(new Persona(5, "Jean", 31));
        personas2.add(new Persona(6, "Jean", 32));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.zip(fx1, fx2, fx3)
                .subscribe(p -> log.info(p.toString()));
    }

    public void zipWith(){
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Jean", 27));
        personas1.add(new Persona(2, "Jean", 28));
        personas1.add(new Persona(3, "Jean", 29));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "Jean", 30));
        personas2.add(new Persona(5, "Jean", 31));
        personas2.add(new Persona(6, "Jean", 32));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        fx1.zipWith(fx2)
                .subscribe(p -> log.info(p.toString()));
    }
}
