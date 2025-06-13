package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
    private Subastador subastador;
    private Integer valorOfertaNueva;

    public Oferta(Subastador subastador, Integer ofertaNuava){
        this.subastador = subastador;
        this.valorOfertaNueva = ofertaNuava;
    }

    public Subastador getSubastador() {
        return subastador;
    }

    public Integer getValorOferta() {
        return valorOfertaNueva;
    }

}
