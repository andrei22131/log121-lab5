package ca.etsmtl.log121.labo5.modele;

public class StrategieCopieTout implements CopieStrategie {

    /**
     * Copie entièrement l'état du memento vers la perspective destination.
     * @param source état à copier
     * @param destination perspective cible
     */
    @Override
    public void appliquer(PerspectiveMemento source, Perspective destination) {
        destination.setZoom(source.getZoom());
        destination.setTranslation(source.getTranslationX(), source.getTranslationY());
    }
}