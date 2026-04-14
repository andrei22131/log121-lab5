package ca.etsmtl.log121.labo5.modele;

public class StrategieCopieTranslation implements CopieStrategie {

    /**
     * Copie uniquement la translation du memento vers la perspective destination.
     * @param source état à copier
     * @param destination perspective cible
     */
    @Override
    public void appliquer(PerspectiveMemento source, Perspective destination) {
        destination.setTranslation(source.getTranslationX(), source.getTranslationY());
    }
}