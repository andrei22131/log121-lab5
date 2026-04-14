package ca.etsmtl.log121.labo5.controleur;

import java.util.Stack;

public class GestionnaireCommande {

    private static GestionnaireCommande instance;
    private final Stack<Commande> historique;
    private final Stack<Commande> redo;

    private GestionnaireCommande() {
        historique = new Stack<>();
        redo = new Stack<>();
    }

    /**
     * Retourne l'unique instance du gestionnaire (Singleton).
     * @return instance de GestionnaireCommande
     */
    public static GestionnaireCommande getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommande();
        }
        return instance;
    }

    /**
     * Exécute une commande et l'ajoute à l'historique.
     * @param commande commande à exécuter
     */
    public void executerCommande(Commande commande) {
        commande.executer();
        historique.push(commande);
        redo.clear();
    }

    /**
     * Ajoute une commande à l'historique sans l'exécuter.
     * @param commande commande à ajouter
     */
    public void ajouterCommande(Commande commande) {
        historique.push(commande);
        redo.clear();
    }

    /**
     * Annule la dernière commande exécutée.
     */
    public void annulerDerniereCommande() {
        if (!historique.isEmpty()) {
            Commande derniereCommande = historique.pop();
            derniereCommande.annuler();
            redo.push(derniereCommande);
        }
    }

    /**
     * Réexécute la dernière commande annulée.
     */
    public void refaireDerniereCommande() {
        if (!redo.isEmpty()) {
            Commande commandeARefaire = redo.pop();
            commandeARefaire.executer();
            historique.push(commandeARefaire);
        }
    }
}