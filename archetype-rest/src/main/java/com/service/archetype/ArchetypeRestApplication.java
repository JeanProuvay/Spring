package com.service.archetype;

import com.service.archetype.data.entity.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArchetypeRestApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ArchetypeRestApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(ArchetypeRestApplication.class, args);
        //Inyeccion de dependencia
        Car car = context.getBean(Car.class);
        System.out.println(car.getMarca());
        System.out.println(car.getModelo());
        System.out.println(car.getMotor().getMarca());
        System.out.println(car.getMotor().getModelo());
    }
}
