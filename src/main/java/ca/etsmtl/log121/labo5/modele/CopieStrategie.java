package ca.etsmtl.log121.labo5.modele;

public interface CopieStrategie {
    void appliquer(PerspectiveMemento source, Perspective destination);
}
