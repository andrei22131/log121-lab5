package ca.etsmtl.log121.labo5.modele;

// Interface Observateur avec les vues implémentent cette interface pour être notifiées des changements dans les sujets observables du modèle
public interface Observateur {

    //Appelée par le SujetObservable lorsque son état change
    void miseAJour();
}