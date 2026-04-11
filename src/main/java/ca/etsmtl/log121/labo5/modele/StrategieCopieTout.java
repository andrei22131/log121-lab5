package ca.etsmtl.log121.labo5.modele;

public class StrategieCopieTout implements CopieStrategie {
    @Override
    public void appliquer(PerspectiveMemento source, Perspective destination) {
        destination.setZoom(source.getZoom());
        destination.setTranslation(source.getTranslationX(), source.getTranslationY());
    }
}
