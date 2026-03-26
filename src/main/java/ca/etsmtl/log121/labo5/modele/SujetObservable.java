package ca.etsmtl.log121.labo5.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Classe abstraite SujetObservable qui gère une liste d'observateurs et les notifie lors de changements d'état

public abstract class SujetObservable implements Serializable {

    private transient List<Observateur> observateurs = new ArrayList<>();

    public void ajouterObservateur(Observateur obs) {
        if (observateurs == null) {
            observateurs = new ArrayList<>();
        }
        observateurs.add(obs);
    }

    public void retirerObservateur(Observateur obs) {
        if (observateurs != null) {
            observateurs.remove(obs);
        }
    }


    public void notifierObservateurs() {
        if (observateurs == null) return;
        for (Observateur obs : observateurs) {
            obs.miseAJour();
        }
    }
}