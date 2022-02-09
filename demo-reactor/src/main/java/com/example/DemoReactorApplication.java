package com.example;

import com.example.model.Persona;
import com.example.operador.combinacion.Combinacion;
import com.example.operador.condicional.Condicional;
import com.example.operador.creacion.Creacion;
import com.example.operador.error.ErrorOp;
import com.example.operador.filtrado.Filtrado;
import com.example.operador.matematico.Matematico;
import com.example.operador.transformacion.Transformacion;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    //REACTOR
    public void reactor(){
        Mono.just(new Persona(1, "Jean", 28))
                .doOnNext(p -> log.info("[reactor] Peronsa: " + p));
                //.subscribe(p -> log.info("[reactor] Peronsa: " + p));
    }

    public void mono(){
        Mono.just(new Persona(1, "Jean", 28))
                .subscribe(p -> log.info("[reactor] Peronsa: " + p));
    }

    public void flux(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(3, "Jean", 28));

        Flux.fromIterable(personas)
                .subscribe(p -> log.info("[reactor] Peronsa: " + p));
    }

    public void fluxMono(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Jean", 28));
        personas.add(new Persona(2, "Jean", 28));
        personas.add(new Persona(3, "Jean", 28));

        Flux<Persona> fx = Flux.fromIterable(personas);
        fx.collectList().subscribe(lista -> log.info(lista.toString()));
    }

    //RXJAVA2
    public void rxjava2(){
        Observable.just(new Persona(1, "Jean", 28))
                .doOnNext(p -> log.info("[reactor] Peronsa: " + p));
                //.subscribe(p -> log.info("[rxjava] Peronsa: " + p));
    }



    public static void main(String[] args)  {
        SpringApplication.run(DemoReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //reactor();
        //rxjava2();

        Creacion creacion = new Creacion();
        //creacion.range();
        //creacion.repeat();

        Transformacion transformacion = new Transformacion();
        //transformacion.map();
        //transformacion.flatMap();
        //transformacion.groupBy();

        Filtrado filtrado = new Filtrado();
        //filtrado.filter();
        //filtrado.distinct();
        //filtrado.take();
        //filtrado.takeLast();
        //filtrado.skip();
        //filtrado.skipLast();

        Combinacion combinacion = new Combinacion();
        //combinacion.merge();
        //combinacion.zip();
        //combinacion.zipWith();

        ErrorOp errorOp = new ErrorOp();
        //errorOp.retry();
        //errorOp.errorReturn();
        //errorOp.errorResume();
        //errorOp.errorMap();

        Condicional condicional = new Condicional();
        //condicional.defaultIfEmpty();
        //condicional.takeUntil();
        //condicional.timeout();

        Matematico matematico = new Matematico();
        //matematico.average();
        //matematico.count();
        //matematico.min();
        //matematico.sum();
        //matematico.summarizing();
    }
}
