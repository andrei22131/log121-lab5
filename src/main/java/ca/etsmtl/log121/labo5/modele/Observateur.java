package ca.etsmtl.log121.labo5.modele;

// Interface Observateur avec les vues implémentent cette interface pour être notifiées des changements dans les sujets observables du modèle
public interface Observateur {

    /**
     * Méthode appelée lorsque le sujet observable change d'état.
     */
    void miseAJour();
}