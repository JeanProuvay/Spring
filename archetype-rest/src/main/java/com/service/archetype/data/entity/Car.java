package com.service.archetype.data.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

    //@Value("VW") //Inyeccion por atributo
    private String marca;
    //@Value("1") //Inyeccion por atributo
    private Integer modelo;
    //@Autowired //Inyeccion por atributo
    private Motor motor;

    public Car() {
    }
    /*
    public Car(String marca, Integer modelo, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }
    */

    //Inyeccion por constructor
    /*
    @Autowired
    public Car(@Value("VW") String marca, @Value("1") Integer modelo, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }
     */

    public String getMarca() {
        return marca;
    }

    @Value("VW") //Inyeccion por setter
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    @Value("1") //Inyeccion por setter
    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    @Autowired //Inyeccion por setter
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
