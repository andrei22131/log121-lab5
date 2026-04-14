package ca.etsmtl.log121.labo5.serialisation;

import ca.etsmtl.log121.labo5.modele.Perspective;

import java.io.Serializable;

public class DonneesSauvegarde implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String cheminImage;
    private final Perspective perspective1;
    private final Perspective perspective2;

    /**
     * Crée un objet de sauvegarde avec une copie des perspectives.
     * @param cheminImage chemin de l'image
     * @param perspective1 première perspective
     * @param perspective2 deuxième perspective
     */
    public DonneesSauvegarde(String cheminImage, Perspective perspective1, Perspective perspective2) {
        this.cheminImage = cheminImage;
        this.perspective1 = perspective1.copier();
        this.perspective2 = perspective2.copier();
    }

    /**
     * Retourne le chemin de l'image.
     * @return chemin de l'image
     */
    public String getCheminImage() {
        return cheminImage;
    }

    /**
     * Retourne la première perspective sauvegardée.
     * @return perspective 1
     */
    public Perspective getPerspective1() {
        return perspective1;
    }

    /**
     * Retourne la deuxième perspective sauvegardée.
     * @return perspective 2
     */
    public Perspective getPerspective2() {
        return perspective2;
    }
}