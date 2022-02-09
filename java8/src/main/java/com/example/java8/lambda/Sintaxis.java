package com.example.java8.lambda;

public class Sintaxis {
    public double probarSintaxis(){
        //Operacion operacion = (double x, double y) -> (x+y)/2;

        Operacion operacion = (x, y) -> {
            return (x+y)/2;
        };

        return operacion.calcularPromedio(2,3);
    }

    public static void main(String[] args) {
        Sintaxis app = new Sintaxis();
        System.out.println(app.probarSintaxis());

    }
}

/*
    En lambda las variables locales (dentro de un metodo) no se pueden modificar, se comportan como variables final
    Variables static y globales (como atributos de clase) son modificables.
*/