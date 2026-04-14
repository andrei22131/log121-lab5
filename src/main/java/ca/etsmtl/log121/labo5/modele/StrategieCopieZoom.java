package ca.etsmtl.log121.labo5.modele;

// Copier uniquement le Zoom
public class StrategieCopieZoom implements CopieStrategie {

    /**
     * Copie uniquement le zoom du memento vers la perspective destination.
     * @param source état à copier
     * @param destination perspective cible
     */
    @Override
    public void appliquer(PerspectiveMemento source, Perspective destination) {
        destination.setZoom(source.getZoom());
    }
}