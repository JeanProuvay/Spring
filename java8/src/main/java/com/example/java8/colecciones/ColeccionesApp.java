package com.example.java8.colecciones;

import org.springframework.cache.annotation.CacheConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ColeccionesApp {
    private List<String> lista;

    public void llenarLista(){
        lista = new ArrayList<>();
        lista.add("MitoCode");
        lista.add("Mito");
        lista.add("Code");
    }

    public void usarForEach(){
        /*
        for(String elemento: lista){
            System.out.println(elemento);
        }
         */

        //lista.forEach(elemento -> System.out.println(elemento));

        lista.forEach(System.out::println);
    }

    public void usarRemoveIf(){
        /*
        Iterator<String> elemento = lista.iterator();
        while(elemento.hasNext()){
            if(elemento.next().equalsIgnoreCase("Code")){
                elemento.remove();
            }
        }
         */
        lista.removeIf(elemento -> elemento.equalsIgnoreCase("Mito"));
    }

    public void usarSort(){
        //lista.sort((x,y)-> x.compareTo(y));
        lista.sort(String::compareTo);
    }

    public static void main(String... arg){
        ColeccionesApp app = new ColeccionesApp();
        app.llenarLista();
        app.usarForEach();
        app.usarRemoveIf();
        app.usarSort();
        app.usarForEach();
    }
}
