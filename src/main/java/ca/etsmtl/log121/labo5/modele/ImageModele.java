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

    //Charge une image à partir d'un chemin sur le disque et notifie tous les observateurs après le chargement
    public void chargerImage(String chemin) {
        this.cheminImage = chemin;
        this.image = new javafx.scene.image.Image("file:" + chemin);
        notifierObservateurs();
    }

    //Retourne l'objet Image JavaFX et reconstruit l'image si elle est null
    public javafx.scene.image.Image getImage() {
        if (image == null && cheminImage != null) {
            image = new javafx.scene.image.Image("file:" + cheminImage);
        }
        return image;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public boolean estChargee() {
        return cheminImage != null;
    }
}