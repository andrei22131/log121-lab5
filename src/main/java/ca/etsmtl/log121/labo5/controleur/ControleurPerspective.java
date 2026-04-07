package ca.etsmtl.log121.labo5.controleur;

import ca.etsmtl.log121.labo5.modele.Perspective;
import javafx.scene.image.ImageView;

public class ControleurPerspective {

    private final Perspective perspective;
    private final ImageView imageView;

    private Perspective etatInitialZoom;
    private boolean zoomEnCours = false;

    private double lastX;
    private double lastY;
    private Perspective etatInitialDrag; //drag : translation

    public ControleurPerspective(Perspective perspective, ImageView imageView) {
        this.perspective = perspective;
        this.imageView = imageView;

        initialiser();
    }

    private void initialiser() {

        //etats initiaux pour zoom et translation
        imageView.setOnMousePressed(e -> {
            //debut (potentiel) zoom
            etatInitialZoom = perspective.copier();
            zoomEnCours = true;

            //debut translation
            lastX = e.getSceneX();
            lastY = e.getSceneY();
            etatInitialDrag = perspective.copier();
        });

        imageView.setOnScroll(event -> {
            //appliquer zoom de maniere continue
            double facteur = event.getDeltaY() > 0 ? 1.2 : 0.8;
            double nouveauZoom = perspective.getZoom() * facteur;

            perspective.setZoom(nouveauZoom);
        });

        //translation
        imageView.setOnMouseDragged(e -> {
            double dx = e.getSceneX() - lastX; //dx : deplacement en x
            double dy = e.getSceneY() - lastY; //dy : deplacement en y

            perspective.setTranslation(
                etatInitialDrag.getTranslateX() + dx, 
                etatInitialDrag.getTranslateY() + dy  
            );
        });

        //fin des actions : creation des commandes
        imageView.setOnMouseReleased(e -> {

            //zoom
            if (zoomEnCours) {
                Perspective apresZoom = perspective.copier();
                CommandePerspective cmdZoom =
                    new CommandePerspective(perspective, etatInitialZoom, apresZoom);
                GestionnaireCommande.getInstance().executerCommande(cmdZoom);
                zoomEnCours = false;
            }
            
            //translation
            Perspective apresDrag = perspective.copier();
            CommandePerspective cmdDrag =
                new CommandePerspective(perspective, etatInitialDrag, apresDrag);
            GestionnaireCommande.getInstance().executerCommande(cmdDrag);
        });
    }
}