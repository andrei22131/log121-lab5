package ca.etsmtl.log121.labo5.commande;

import ca.etsmtl.log121.labo5.modele.Perspective;

public class CommandeZoom implements Commande {
    private Perspective perspective;
    private double nouveauFacteur;
    private double ancienFacteur;

    public CommandeZoom(Perspective perspective, double nouveauFacteur) {
        this.perspective = perspective;
        this.nouveauFacteur = nouveauFacteur;
    }

    @Override
    public void executer() {
        ancienFacteur = perspective.getZoom();
        perspective.setZoom(nouveauFacteur);
    }

    @Override
    public void annuler() {
        perspective.setZoom(ancienFacteur);
    }
}
