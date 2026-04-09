package ca.etsmtl.log121.labo5.controleur;

import java.util.Stack;

//Instance unique qui gère la pile de commandes exécutées et permet le undo
public class GestionnaireCommande {

    private static GestionnaireCommande instance;
    private final Stack<Commande> historique;
    private final Stack<Commande> redo;

    private GestionnaireCommande() {
        historique = new Stack<>();
        redo = new Stack<>();
    }

    public static GestionnaireCommande getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommande();
        }
        return instance;
    }

    //Exécute une commande et l'empile pour le undo
    public void executerCommande(Commande commande) {
        commande.executer();
        historique.push(commande);
        redo.clear();
    }

    //Ajoute une commande à l'historique sans l'exécuter et aussi utile quand l'action a déjà été appliquée
    public void ajouterCommande(Commande commande) {
        historique.push(commande);
        redo.clear();
    }

    //Annule la dernière commande exécutée
    public void annulerDerniereCommande() {
        if (!historique.isEmpty()) {
            Commande derniereCommande = historique.pop();
            derniereCommande.annuler();
            redo.push(derniereCommande);
        }
    }

    // Refait la dernière commande annulée (Redo)
    public void refaireDerniereCommande() {
        if (!redo.isEmpty()) {
            Commande commandeARefaire = redo.pop();
            commandeARefaire.executer();
            historique.push(commandeARefaire);
        }
    }
}
