package ca.etsmtl.log121.labo5.vue;

import ca.etsmtl.log121.labo5.controleur.ControleurPerspective;
import ca.etsmtl.log121.labo5.modele.ImageModele;
import ca.etsmtl.log121.labo5.modele.Observateur;
import ca.etsmtl.log121.labo5.modele.Perspective;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class VuePerspective extends BorderPane implements Observateur {

    private final ImageModele imageModele;
    private final Perspective perspective;
    private final ImageView imageView;
    private final ControleurPerspective controleur;

    /**
     * Constructeur de la vue perspective.
     *
     * @param imageModele le modèle contenant l'image
     * @param perspective la perspective associée
     */
    public VuePerspective(ImageModele imageModele, Perspective perspective) {
        this.imageModele = imageModele;
        this.perspective = perspective;

        imageModele.ajouterObservateur(this);
        perspective.ajouterObservateur(this);

        imageView = new ImageView();
        imageView.setPreserveRatio(false);

        ScrollPane scrollPane = new ScrollPane(imageView);
        scrollPane.setPannable(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        setCenter(scrollPane);
        setPadding(new Insets(5));
        controleur = new ControleurPerspective(perspective, imageView);
    }

    /**
     * Méthode appelée lors d'une mise à jour du modèle.
     * Met à jour l'image affichée dans la vue.
     */
    @Override
    public void miseAJour() {
        Image img = imageModele.getImage();
        imageView.setImage(img);

        imageView.setScaleX(perspective.getZoom());
        imageView.setScaleY(perspective.getZoom());

        //...
        imageView.setTranslateX(perspective.getTranslateX());
        imageView.setTranslateY(perspective.getTranslateY());
    }
}