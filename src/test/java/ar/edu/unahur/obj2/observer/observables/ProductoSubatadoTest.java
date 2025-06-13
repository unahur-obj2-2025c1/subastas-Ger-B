package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {
    ProductoSubatado lampara = new ProductoSubatado();
    Subastador gonzager = new Subastador("Gonza"); 
    Subastador diazDan = new Subastador("Daniel"); 
    Subastador martumau = new Subastador("NombreRaro");

    @BeforeEach
    public void escenario1(){
        lampara.reset();
        gonzager.reset();
        diazDan.reset();
        martumau.reset();

        lampara.setObservadores(diazDan);
        lampara.setObservadores(martumau);

        // martumau.hacerOferta(lampara, 10);
        // gonzager.hacerOferta(lampara, 20);
        // martumau.hacerOferta(lampara, 30);
    }

    @Test
    public void primerTest(){
        assertEquals(0, martumau.getUltimaOfertaRecibida().getValorOferta());
    }
}
