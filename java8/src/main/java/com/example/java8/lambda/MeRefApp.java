package com.example.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {
    public static void referenciarMetodoStatic(){
        System.out.println("Metodo Referido static");
    }

    public void referenciarMetodoInstanciaObjectoArbitrario(){
        String[] nombres = {"Mito","Code","Jaime"};
        /*
        Arrays.sort(nombres, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
         */

        //Arrays.sort(nombres, (o1, o2)-> o1.compareToIgnoreCase(o2)); //Lambda

        Arrays.sort(nombres, String::compareToIgnoreCase); //Method Reference

        System.out.println(Arrays.toString(nombres));
    }

    public void referenciarMetodoInstanciaObjectoParticular(){
        System.out.println("Metodo Referido Instancia de Clase");
    }

    public void referenciarConstructor(){
        /*
        IPersona per = new IPersona() {
            @Override
            public Persona crear(int id, String nombre) {
                return new Persona(id, nombre);
            }
        };
         */
        //IPersona per = (id, nombre) -> new Persona(id, nombre);

        IPersona iper = Persona::new;

        Persona per = iper.crear(1,"Jean");
        System.out.println(per.toString());
    }

    public void operar(){
        Operacion2 op = () -> MeRefApp.referenciarMetodoStatic(); //Lambda
        Operacion2 op2 = MeRefApp::referenciarMetodoStatic; //Method Reference
        op.saludar();
        op2.saludar();
    }




    public static void main(String[] args) {
        MeRefApp app = new MeRefApp();
        app.operar();

        app.referenciarMetodoInstanciaObjectoArbitrario();

        Operacion2 op = app::referenciarMetodoInstanciaObjectoParticular;
        op.saludar();

        app.referenciarConstructor();

    }

}
