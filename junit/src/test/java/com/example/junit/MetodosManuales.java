package com.example.junit;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class MetodosManuales {

    @Before
    public void setUp(){
        System.out.println("Antes de cada test");
    }

    @After
    public void tearDown(){
        System.out.println("Despues de cada test");
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Antes de todos los test");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("Despues de todos los test");
    }

    @Test
    public void primerTest(){
        System.out.println("Primer test");
    }

    @Test
    public void segundoTest(){
        System.out.println("Segundo test");
    }
}
