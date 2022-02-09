package com.example.junit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsNull.notNullValue;
//import org.hamcrest.Matchers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UtilidadesTest {

    @Test
    public void concatenarTest(){
        //Instanciar la clase a probar
        Utilidades utilidades = new Utilidades();
        String resultado = utilidades.concatenar("hola ", "mundo");

        //Validaciones
        Assert.assertEquals("Las cadenas son diferentes","hola mundo", resultado);
        assertEquals("Las cadenas son diferentes","hola mundo", resultado);

        assertThat(resultado, is(equalTo("hola mundo")));
        assertThat(resultado, equalTo("hola mundo"));

        assertThat(resultado, is(not(equalTo("holamundo"))));
        assertThat(resultado, not(equalTo("holamundo")));

        assertThat(resultado, not(nullValue()));
        assertThat(resultado, notNullValue());

        //assertThat(resultado, Matchers.);
    }
}
