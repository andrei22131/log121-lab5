package ca.etsmtl.log121.labo5.modele;

// Copier uniquement le Zoom
public class StrategieCopieZoom implements CopieStrategie {
    @Override
    public void appliquer(PerspectiveMemento source, Perspective destination) {
        destination.setZoom(source.getZoom());
    }
}