package ca.etsmtl.log121.labo5.modele;

import java.io.Serializable;

public class PerspectiveMemento implements Serializable {
    private static final long serialVersionUID = 1L;

    private final double zoom;
    private final double translationX;
    private final double translationY;

    public PerspectiveMemento(double zoom, double translationX, double translationY) {
        this.zoom = zoom;
        this.translationX = translationX;
        this.translationY = translationY;
    }

    public double getZoom() { return zoom; }
    public double getTranslationX() { return translationX; }
    public double getTranslationY() { return translationY; }
}