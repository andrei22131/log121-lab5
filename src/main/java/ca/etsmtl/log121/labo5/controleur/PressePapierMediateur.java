package ca.etsmtl.log121.labo5.controleur;

import ca.etsmtl.log121.labo5.modele.Perspective;
import ca.etsmtl.log121.labo5.modele.PerspectiveMemento;
import ca.etsmtl.log121.labo5.modele.CopieStrategie;
import ca.etsmtl.log121.labo5.modele.StrategieCopieTout;

public class PressePapierMediateur {
    private static PressePapierMediateur instance;

    private PerspectiveMemento donneesCopiees;
    private CopieStrategie strategieCourante;

    private PressePapierMediateur() {
        strategieCourante = new StrategieCopieTout();
    }

    /**
     * Retourne l'unique instance du presse-papier (Singleton).
     * @return instance du PressePapierMediateur
     */
    public static PressePapierMediateur getInstance() {
        if (instance == null) {
            instance = new PressePapierMediateur();
        }
        return instance;
    }

    /**
     * Définit la stratégie de copie à utiliser.
     * @param strategie nouvelle stratégie de copie
     */
    public void setStrategie(CopieStrategie strategie) {
        this.strategieCourante = strategie;
    }

    /**
     * Copie l'état de la perspective source.
     * @param source perspective à copier
     */
    public void copier(Perspective source) {
        this.donneesCopiees = source.sauvegarderEtat();
    }

    /**
     * Colle les données copiées dans la perspective destination
     * en utilisant la stratégie courante.
     * @param destination perspective cible
     */
    public void coller(Perspective destination) {
        if (donneesCopiees != null) {
            strategieCourante.appliquer(donneesCopiees, destination);
        }
    }

    /**
     * Vérifie si le presse-papier est vide.
     * @return true si aucune donnée n'est copiée
     */
    public boolean estVide() {
        return donneesCopiees == null;
    }
}