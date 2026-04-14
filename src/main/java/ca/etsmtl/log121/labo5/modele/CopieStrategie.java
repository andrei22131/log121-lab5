package ca.etsmtl.log121.labo5.modele;

public interface CopieStrategie {

    /**
     * Applique une stratégie de copie du memento vers une perspective.
     * @param source état à copier
     * @param destination perspective cible
     */
    void appliquer(PerspectiveMemento source, Perspective destination);
}