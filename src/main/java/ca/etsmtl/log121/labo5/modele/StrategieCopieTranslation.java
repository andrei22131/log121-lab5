package ca.etsmtl.log121.labo5.modele;

public class StrategieCopieTranslation implements CopieStrategie{
    @Override
    public void appliquer(PerspectiveMemento source, Perspective destination) {
        destination.setTranslation(source.getTranslationX(), source.getTranslationY());
    }
}
