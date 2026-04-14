package ca.etsmtl.log121.labo5.vue;

import ca.etsmtl.log121.labo5.modele.ImageModele;
import ca.etsmtl.log121.labo5.modele.Observateur;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

//Affiche une version réduite de l'image, sans zoom ni translation
public class VueVignette extends Pane implements Observateur {

    private final Canvas canvas;
    private final ImageModele imageModele;

    /**
     * Initialise la vue vignette avec le modèle d'image.
     * @param imageModele modèle contenant l'image
     */
    public VueVignette(ImageModele imageModele) {
        this.imageModele = imageModele;

        canvas = new Canvas();
        getChildren().add(canvas);

        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());

        widthProperty().addListener((obs, o, n) -> dessiner());
        heightProperty().addListener((obs, o, n) -> dessiner());

        imageModele.ajouterObservateur(this);

        setStyle("-fx-border-color: black; -fx-border-width: 1;");
    }

    /**
     * Met à jour la vue lorsque le modèle change.
     */
    @Override
    public void miseAJour() {
        dessiner();
    }

    /**
     * Dessine l'image en l'adaptant à la taille de la vignette.
     */
    private void dessiner() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double w = canvas.getWidth();
        double h = canvas.getHeight();

        gc.clearRect(0, 0, w, h);

        Image img = imageModele.getImage();
        if (img == null) return;

        //calculer le ratio pour que l'image tienne dans la vignette
        double ratioX = w / img.getWidth();
        double ratioY = h / img.getHeight();
        double ratio = Math.min(ratioX, ratioY);

        double imgW = img.getWidth() * ratio;
        double imgH = img.getHeight() * ratio;
        double offsetX = (w - imgW) / 2;
        double offsetY = (h - imgH) / 2;

        gc.drawImage(img, offsetX, offsetY, imgW, imgH);
    }
}