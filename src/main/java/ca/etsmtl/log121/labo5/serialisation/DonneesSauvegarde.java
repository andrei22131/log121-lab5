package ca.etsmtl.log121.labo5.serialisation;

import ca.etsmtl.log121.labo5.modele.Perspective;

import java.io.Serializable;

//le chemin de l'image et les deux perspectives
public class DonneesSauvegarde implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String cheminImage;
    private final Perspective perspective1;
    private final Perspective perspective2;

    public DonneesSauvegarde(String cheminImage, Perspective perspective1, Perspective perspective2) {
        this.cheminImage = cheminImage;
        this.perspective1 = perspective1.copier();
        this.perspective2 = perspective2.copier();
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public Perspective getPerspective1() {
        return perspective1;
    }

    public Perspective getPerspective2() {
        return perspective2;
    }
}
