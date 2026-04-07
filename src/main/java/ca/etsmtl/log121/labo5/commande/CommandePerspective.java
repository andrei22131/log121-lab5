package ca.etsmtl.log121.labo5.commande;

import ca.etsmtl.log121.labo5.modele.Perspective;

public class CommandePerspective implements Commande {

    private final Perspective cible;
    private final Perspective avant;
    private final Perspective apres;

    public CommandePerspective(Perspective cible, Perspective avant, Perspective apres) {
        this.cible = cible;
        this.avant = avant;
        this.apres = apres;
    }

    @Override
    public void executer() {
        cible.restaurer(apres);
    }

    @Override
    public void annuler() {
        cible.restaurer(avant);
    }
}