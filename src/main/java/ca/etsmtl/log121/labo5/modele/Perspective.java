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

    /**
     * Initialise une perspective avec translation et zoom.
     * @param translateX translation en X
     * @param translateY translation en Y
     * @param zoom niveau de zoom
     */
    public Perspective(double translateX, double translateY, double zoom) {
        this.translateX = translateX;
        this.translateY = translateY;
        this.zoom = zoom;
    }

    /**
     * Retourne la translation en X.
     * @return translation X
     */
    public double getTranslateX() {
        return translateX;
    }

    /**
     * Retourne la translation en Y.
     * @return translation Y
     */
    public double getTranslateY() {
        return translateY;
    }

    /**
     * Retourne le niveau de zoom.
     * @return zoom
     */
    public double getZoom() {
        return zoom;
    }

    /**
     * Modifie la translation et notifie les observateurs.
     * @param x nouvelle valeur X
     * @param y nouvelle valeur Y
     */
    public void setTranslation(double x, double y) {
        this.translateX = x;
        this.translateY = y;
        notifierObservateurs();
    }

    /**
     * Modifie le zoom et notifie les observateurs.
     * @param zoom nouveau niveau de zoom
     */
    public void setZoom(double zoom) {
        this.zoom = zoom;
        notifierObservateurs();
    }

    /**
     * Crée une copie de la perspective.
     * @return nouvelle instance copiée
     */
    public Perspective copier() {
        return new Perspective(translateX, translateY, zoom);
    }

    /**
     * Restaure l'état à partir d'une autre perspective.
     * @param autre perspective source
     */
    public void restaurer(Perspective autre) {
        this.translateX = autre.translateX;
        this.translateY = autre.translateY;
        this.zoom = autre.zoom;
        notifierObservateurs();
    }

    /**
     * Restaure l'état à partir d'un memento.
     * @param memento état sauvegardé
     */
    public void restaurerEtat(PerspectiveMemento memento) {
        this.zoom = memento.getZoom();
        this.translateX = memento.getTranslationX();
        this.translateY = memento.getTranslationY();
        notifierObservateurs();
    }

    /**
     * Sauvegarde l'état courant sous forme de memento.
     * @return memento de la perspective
     */
    public PerspectiveMemento sauvegarderEtat() {
        return new PerspectiveMemento(this.zoom, this.translateX, this.translateY);
    }
}