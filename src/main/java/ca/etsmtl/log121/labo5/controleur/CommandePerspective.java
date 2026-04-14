package ca.etsmtl.log121.labo5.controleur;

import ca.etsmtl.log121.labo5.modele.Perspective;

public class CommandePerspective implements Commande {

    private final Perspective cible;
    private final Perspective avant;
    private final Perspective apres;

    /**
     * Crée une commande avec l'état avant et après modification.
     * @param cible perspective à modifier
     * @param avant état initial
     * @param apres état final
     */
    public CommandePerspective(Perspective cible, Perspective avant, Perspective apres) {
        this.cible = cible;
        this.avant = avant;
        this.apres = apres;
    }

    /**
     * Applique l'état après modification à la perspective.
     */
    @Override
    public void executer() {
        cible.restaurer(apres);
    }

    /**
     * Restaure l'état initial de la perspective.
     */
    @Override
    public void annuler() {
        cible.restaurer(avant);
    }
}