package ca.etsmtl.log121.labo5.vue;

import ca.etsmtl.log121.labo5.controleur.CommandePerspective;
import ca.etsmtl.log121.labo5.controleur.GestionnaireCommande;
import ca.etsmtl.log121.labo5.modele.ImageModele;
import ca.etsmtl.log121.labo5.modele.Observateur;
import ca.etsmtl.log121.labo5.modele.Perspective;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;

//Vue dans MVC, Observateur dans le patron Observer
public class VuePerspective extends Pane implements Observateur {

    private final Canvas canvas;
    private final ImageModele imageModele;
    private final Perspective perspective;

    private double debutDragX, debutDragY;
    private double debutTransX, debutTransY;
    private boolean enDrag = false;

    public VuePerspective(ImageModele imageModele, Perspective perspective) {
        this.imageModele = imageModele;
        this.perspective = perspective;

        canvas = new Canvas();
        getChildren().add(canvas);

        //ici le canvas suit la taille du Pane
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());

        widthProperty().addListener((obs, o, n) -> dessiner());
        heightProperty().addListener((obs, o, n) -> dessiner());

        //s'abonner comme observateur
        imageModele.ajouterObservateur(this);
        perspective.ajouterObservateur(this);

        setStyle("-fx-border-color: blue; -fx-border-width: 2;");

        configurerSouris();
    }

    private void configurerSouris() {
        //translation par glisser
        setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                debutDragX = e.getSceneX();
                debutDragY = e.getSceneY();
                debutTransX = perspective.getTranslateX();
                debutTransY = perspective.getTranslateY();
                enDrag = true;
            }
        });

        setOnMouseDragged(e -> {
            if (enDrag) {
                double dx = e.getSceneX() - debutDragX;
                double dy = e.getSceneY() - debutDragY;
                // Mise à jour directe pendant le drag (sans commande)
                perspective.setTranslation(debutTransX + dx, debutTransY + dy);
            }
        });

        setOnMouseReleased(e -> {
            if (enDrag && e.getButton() == MouseButton.PRIMARY) {
                enDrag = false;
                double nouveauX = perspective.getTranslateX();
                double nouveauY = perspective.getTranslateY();

                if (nouveauX != debutTransX || nouveauY != debutTransY) {
                    // Restaurer l'ancien état puis exécuter via commande pour le undo
                    Perspective avant = new Perspective(debutTransX, debutTransY, perspective.getZoom());
                    Perspective apres = new Perspective(nouveauX, nouveauY, perspective.getZoom());
                    perspective.setTranslation(debutTransX, debutTransY);
                    CommandePerspective cmd = new CommandePerspective(perspective, avant, apres);
                    GestionnaireCommande.getInstance().executerCommande(cmd);
                }
            }
        });

        //zoom par molette de souris
        addEventHandler(ScrollEvent.SCROLL, e -> {
            double facteur = e.getDeltaY() > 0 ? 1.1 : 0.9;
            double ancienZoom = perspective.getZoom();
            double nouveauZoom = ancienZoom * facteur;

            Perspective avant = new Perspective(perspective.getTranslateX(), perspective.getTranslateY(), ancienZoom);
            Perspective apres = new Perspective(perspective.getTranslateX(), perspective.getTranslateY(), nouveauZoom);

            CommandePerspective cmd = new CommandePerspective(perspective, avant, apres);
            GestionnaireCommande.getInstance().executerCommande(cmd);
        });
    }

    @Override
    public void miseAJour() {
        dessiner();
    }

    private void dessiner() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double w = canvas.getWidth();
        double h = canvas.getHeight();

        gc.clearRect(0, 0, w, h);

        Image img = imageModele.getImage();
        if (img == null) return;

        double zoom = perspective.getZoom();
        double tx = perspective.getTranslateX();
        double ty = perspective.getTranslateY();

        double imgW = img.getWidth() * zoom;
        double imgH = img.getHeight() * zoom;

        gc.drawImage(img, tx, ty, imgW, imgH);
    }

    public Perspective getPerspective() {
        return perspective;
    }
}
