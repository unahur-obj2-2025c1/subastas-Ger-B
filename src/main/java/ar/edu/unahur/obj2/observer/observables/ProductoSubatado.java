package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class ProductoSubatado implements Observable{
    private Oferta ofertaActual = new Oferta(new Subastador("LaCasa"), 0);
    private Set<Subastador> subastadores = new HashSet<>();
    private List<Oferta> registroOfertas = new ArrayList<>();
    
    @Override
    public void notificar() {
        subastadores.forEach(sub -> sub.actualizar(ofertaActual));
    }

    public void setNewOferta(Oferta nuevaOferta){
        Subastador subastador = nuevaOferta.getSubastador();
        if(!subastadores.contains(subastador)){
            throw new OfertaSubastadorException("El subastador no participa en la subasta");
        }
        this.ofertaActual = nuevaOferta;
        registroOfertas.add(nuevaOferta);
        this.notificar();
    }

    
    public Set<Subastador> getObservadores() {
        return subastadores;
    }
    
    public void setObservadores(Subastador newSubastador) {
        this.subastadores.add(newSubastador);
    }

    public Oferta getOfertaActual(){
        return this.ofertaActual;
    }
    public void reset(){
        this.ofertaActual = new Oferta(new Subastador("LaCasa"), 0);

    }
}
