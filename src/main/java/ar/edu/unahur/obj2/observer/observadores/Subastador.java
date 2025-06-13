package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;

public class Subastador implements Observer {
    private Oferta ultimaOfertaRecibida = new Oferta(new Subastador("LaCasa"), 0);
    private final String nombre;

    public Subastador(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Oferta ofertaNueva) {
        this.ultimaOfertaRecibida = ofertaNueva;
    }

    public void hacerOferta(ProductoSubatado producto, Integer valorOferta){
        Integer valorCorrectoDeOferta = this.ultimaOfertaRecibida.getValorOferta() + 10;

        if(valorCorrectoDeOferta != valorOferta){
            throw new OfertaSubastadorException("El valor de la oferta debe ser " + valorCorrectoDeOferta);
        }
        producto.setNewOferta(new Oferta(this, valorOferta));
    }

    public Oferta getUltimaOfertaRecibida() {
        return ultimaOfertaRecibida;
    }

    public String getNombre() {
        return nombre;
    }

    public void reset(){
        ultimaOfertaRecibida = new Oferta(new Subastador("LaCasa"), 0);
    }

}
