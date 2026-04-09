package ca.etsmtl.log121.labo5.controleur;

public interface Commande {
    void executer(); //excecuter le changement (zoom/translation)
    void annuler(); //undo le changement
}
