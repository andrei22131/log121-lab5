package ca.etsmtl.log121.labo5.modele;

import java.io.Serializable;

//Classe ImageModele qui représente l'image chargée dans l'application.
// Hérite de SujetObservable pour notifier ses observateurs (vues) lorsque l'image change
public class ImageModele extends SujetObservable implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cheminImage;
    private transient javafx.scene.image.Image image;

    public ImageModele() {
    }

    /**
     * Charge une image depuis un chemin et notifie les observateurs.
     * @param chemin chemin du fichier image
     */
    public void chargerImage(String chemin) {
        this.cheminImage = chemin;
        this.image = new javafx.scene.image.Image("file:" + chemin);
        notifierObservateurs();
    }

    /**
     * Retourne l'image, en la rechargeant si nécessaire.
     * @return image JavaFX
     */
    public javafx.scene.image.Image getImage() {
        if (image == null && cheminImage != null) {
            image = new javafx.scene.image.Image("file:" + cheminImage);
        }
        return image;
    }

    /**
     * Retourne le chemin de l'image chargée.
     * @return chemin de l'image
     */
    public String getCheminImage() {
        return cheminImage;
    }

    /**
     * Indique si une image est chargée.
     * @return true si une image est disponible
     */
    public boolean estChargee() {
        return cheminImage != null;
    }
}