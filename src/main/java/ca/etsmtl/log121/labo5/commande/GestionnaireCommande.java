package ca.etsmtl.log121.labo5.commande;

import java.util.Stack;

//classe Singleton
public class GestionnaireCommande {

    private static GestionnaireCommande instance;
    private Stack<Commande> historique;

    private GestionnaireCommande() {
        historique = new Stack<>();
    }

    public static GestionnaireCommande getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommande();
        }
        return instance;
    }

    public void executerCommande(Commande commande) {
        commande.executer();
        historique.push(commande);
    }

    public void annulerDerniereCommande() {
        if (!historique.isEmpty()) {
            Commande derniereCommande = historique.pop();
            derniereCommande.annuler();
        }
    }
}
