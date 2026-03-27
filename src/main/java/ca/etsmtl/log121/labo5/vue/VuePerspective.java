package ca.etsmtl.log121.labo5.vue;

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
    }

    @Override
    public void miseAJour() {
        Image img = imageModele.getImage();
        imageView.setImage(img);
    }
}