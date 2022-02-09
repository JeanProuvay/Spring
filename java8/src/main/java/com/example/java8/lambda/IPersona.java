package com.example.java8.lambda;

@FunctionalInterface
public interface IPersona {
    Persona crear(int id, String nombre);
}
