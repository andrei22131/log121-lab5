package ca.etsmtl.log121.labo5.modele;

import java.io.Serializable;

//Classe Perspective qui représente une perspective sur l'image (zoom|translation)
//Hérite de SujetObservable pour notifier ses observateurs (vues) lorsque la perspective change
public class Perspective extends SujetObservable implements Serializable {

    private static final long serialVersionUID = 1L;

    private double translateX = 0;
    private double translateY = 0;
    private double zoom = 1.0;

    public Perspective() {
    }

    public Perspective(double translateX, double translateY, double zoom) {
        this.translateX = translateX;
        this.translateY = translateY;
        this.zoom = zoom;
    }

    public double getTranslateX() {
        return translateX;
    }

    public double getTranslateY() {
        return translateY;
    }

    public double getZoom() {
        return zoom;
    }

    //Modifie la translation et notifie les observateurs
    public void setTranslation(double x, double y) {
        this.translateX = x;
        this.translateY = y;
        notifierObservateurs();
    }

    //Modifie le zoom et notifie les observateurs
    public void setZoom(double zoom) {
        this.zoom = zoom;
        notifierObservateurs();
    }

    //Crée une copie de cette perspective
    public Perspective copier() {
        return new Perspective(translateX, translateY, zoom);
    }

    //Restaure l'état à partir d'une autre perspective et notifie les observateurs
    public void restaurer(Perspective autre) {
        this.translateX = autre.translateX;
        this.translateY = autre.translateY;
        this.zoom = autre.zoom;
        notifierObservateurs();
    }

    public void restaurerEtat(PerspectiveMemento memento) {
        this.zoom = memento.getZoom();
        this.translateX = memento.getTranslationX();
        this.translateY = memento.getTranslationY();
        notifierObservateurs();
    }

    public PerspectiveMemento sauvegarderEtat() {
        return new PerspectiveMemento(this.zoom, this.translateX, this.translateY);
    }
}