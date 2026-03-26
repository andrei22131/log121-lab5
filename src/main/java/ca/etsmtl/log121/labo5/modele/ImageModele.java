package ca.etsmtl.log121.labo5.modele;

import java.io.Serializable;

//Classe ImageModele qui représente l'image chargée dans l'application.
// Hérite de SujetObservable pour notifier ses observateurs (vues) lorsque l'image change
public class ImageModele extends SujetObservable implements Serializable {

    private static final long serialVersionUID = 1L;
}