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

    public static PressePapierMediateur getInstance() {
        if (instance == null) {
            instance = new PressePapierMediateur();
        }
        return instance;
    }

    public void setStrategie(CopieStrategie strategie) {
        this.strategieCourante = strategie;
    }

    public void copier(Perspective source) {
        this.donneesCopiees = source.sauvegarderEtat();
    }

    public void coller(Perspective destination) {
        if (donneesCopiees != null) {
            // L'avantage du Mediator + Strategy combinés :
            // Le Mediator ordonne à la stratégie d'appliquer les données !
            strategieCourante.appliquer(donneesCopiees, destination);
        }
    }

    public boolean estVide() {
        return donneesCopiees == null;
    }
}