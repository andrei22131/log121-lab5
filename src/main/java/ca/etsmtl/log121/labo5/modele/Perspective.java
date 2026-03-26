package ca.etsmtl.log121.labo5.modele;

import java.io.Serializable;

//Classe Perspective qui représente une perspective sur l'image (zoom|translation)
//Hérite de SujetObservable pour notifier ses observateurs (vues) lorsque la perspective change
public class Perspective extends SujetObservable implements Serializable {

    private static final long serialVersionUID = 1L;
}