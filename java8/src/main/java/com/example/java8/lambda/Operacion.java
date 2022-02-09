package com.example.java8.lambda;

@FunctionalInterface
public interface Operacion {

    double calcularPromedio(double n1, double n2);

    /*
        Metodos por defectos en interfaces o Default methods
     */
    default Integer sumar(Integer n1, Integer n2){
        return n1+n2;
    }
}
