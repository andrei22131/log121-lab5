package ca.etsmtl.log121.labo5.modele;

import java.io.Serializable;

public class PerspectiveMemento implements Serializable {
    private static final long serialVersionUID = 1L;

    private final double zoom;
    private final double translationX;
    private final double translationY;

    /**
     * Crée un memento contenant l'état d'une perspective.
     * @param zoom niveau de zoom
     * @param translationX translation en X
     * @param translationY translation en Y
     */
    public PerspectiveMemento(double zoom, double translationX, double translationY) {
        this.zoom = zoom;
        this.translationX = translationX;
        this.translationY = translationY;
    }

    /**
     * Retourne le niveau de zoom sauvegardé.
     * @return zoom
     */
    public double getZoom() { return zoom; }

    /**
     * Retourne la translation en X sauvegardée.
     * @return translation X
     */
    public double getTranslationX() { return translationX; }

    /**
     * Retourne la translation en Y sauvegardée.
     * @return translation Y
     */
    public double getTranslationY() { return translationY; }
}