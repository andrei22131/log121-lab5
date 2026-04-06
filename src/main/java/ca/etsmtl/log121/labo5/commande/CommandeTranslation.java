package ca.etsmtl.log121.labo5.commande;

import ca.etsmtl.log121.labo5.modele.Perspective;

public class CommandeTranslation implements Commande {

    private Perspective perspective;
    private double ancienX;
    private double ancienY;
    private double nouveauX;
    private double nouveauY;

    public CommandeTranslation(Perspective perspective, double nouveauX, double nouveauY) {
        this.perspective = perspective;
        this.nouveauX = nouveauX;
        this.nouveauY = nouveauY;
    }

    @Override
    public void executer() {
        ancienX = perspective.getTranslateX();
        ancienY = perspective.getTranslateY();
        perspective.setTranslation(nouveauX, nouveauY);
    }

    @Override
    public void annuler() {
        perspective.setTranslation(ancienX, ancienY);
    }

}
