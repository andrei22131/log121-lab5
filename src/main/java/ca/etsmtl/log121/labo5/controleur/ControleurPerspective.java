package ca.etsmtl.log121.labo5.controleur;

import ca.etsmtl.log121.labo5.modele.Perspective;
import javafx.scene.image.ImageView;

public class ControleurPerspective {

    private final Perspective perspective;
    private final ImageView imageView;

    // Translation qui est létat au début du drag
    private double debutDragX;
    private double debutDragY;
    private double debutTransX;
    private double debutTransY;
    private boolean enDrag = false;

    // Zoom qui est l'état avant le premier scroll
    private double ancienZoom;
    private boolean zoomModifie = false;

    public ControleurPerspective(Perspective perspective, ImageView imageView) {
        this.perspective = perspective;
        this.imageView = imageView;

        initialiser();
    }

    private void initialiser() {

        // Début du drag qui mémorise la position de départ
        imageView.setOnMousePressed(e -> {
            debutDragX = e.getSceneX();
            debutDragY = e.getSceneY();
            debutTransX = perspective.getTranslateX();
            debutTransY = perspective.getTranslateY();
            enDrag = false;
        });

        // Translation pendant le drag
        imageView.setOnMouseDragged(e -> {
            enDrag = true;
            double dx = e.getSceneX() - debutDragX;
            double dy = e.getSceneY() - debutDragY;
            perspective.setTranslation(debutTransX + dx, debutTransY + dy);
        });

        // Fin du drag qui crée la commande pour le undo
        imageView.setOnMouseReleased(e -> {
            if (enDrag) {
                double nouveauX = perspective.getTranslateX();
                double nouveauY = perspective.getTranslateY();

                // Seulement si la position a vraiment changé
                if (nouveauX != debutTransX || nouveauY != debutTransY) {
                    Perspective avant = new Perspective(debutTransX, debutTransY, perspective.getZoom());
                    Perspective apres = new Perspective(nouveauX, nouveauY, perspective.getZoom());
                    CommandePerspective cmd = new CommandePerspective(perspective, avant, apres);
                    GestionnaireCommande.getInstance().ajouterCommande(cmd);
                }
                enDrag = false;
            }
        });

        // Zoom par molette pour chaque scroll qui crée une commande individuelle
        imageView.setOnScroll(event -> {
            double facteur = event.getDeltaY() > 0 ? 1.2 : 0.8;
            double ancienZoomVal = perspective.getZoom();
            double nouveauZoom = ancienZoomVal * facteur;

            Perspective avant = new Perspective(perspective.getTranslateX(), perspective.getTranslateY(), ancienZoomVal);
            Perspective apres = new Perspective(perspective.getTranslateX(), perspective.getTranslateY(), nouveauZoom);

            CommandePerspective cmd = new CommandePerspective(perspective, avant, apres);
            GestionnaireCommande.getInstance().executerCommande(cmd);
        });
    }
}