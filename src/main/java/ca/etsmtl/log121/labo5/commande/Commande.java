package ca.etsmtl.log121.labo5.commande;

public interface Commande {
    void executer(); //excecuter le changement (zoom/translation)
    void annuler(); //undo le changement
}
