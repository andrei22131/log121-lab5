package ca.etsmtl.log121.labo5.vue;

import ca.etsmtl.log121.labo5.modele.ImageModele;
import ca.etsmtl.log121.labo5.modele.Observateur;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class VueVignette extends BorderPane implements Observateur {

    private static final double MAX_SIZE = 150.0;

    private final ImageModele imageModele;
    private final ImageView imageView;
    private final ScrollPane scrollPane;

    public VueVignette(ImageModele imageModele) {
        this.imageModele = imageModele;
        this.imageModele.ajouterObservateur(this);

        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(MAX_SIZE);
        imageView.setFitHeight(MAX_SIZE);

        scrollPane = new ScrollPane(imageView);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefSize(MAX_SIZE, MAX_SIZE);

        setCenter(scrollPane);
        setPadding(new Insets(5));
    }

    @Override
    public void miseAJour() {
        Image img = imageModele.getImage();
        imageView.setImage(img);
    }
}