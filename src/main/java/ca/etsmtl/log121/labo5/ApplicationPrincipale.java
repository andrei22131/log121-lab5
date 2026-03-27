package ca.etsmtl.log121.labo5;

import ca.etsmtl.log121.labo5.modele.ImageModele;
import ca.etsmtl.log121.labo5.modele.Perspective;
import ca.etsmtl.log121.labo5.vue.VuePerspective;
import ca.etsmtl.log121.labo5.vue.VueVignette;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;

public class ApplicationPrincipale extends Application {

    private final ImageModele imageModele = new ImageModele();
    private final Perspective perspective1 = new Perspective();
    private final Perspective perspective2 = new Perspective();

    private VueVignette vueVignette;
    private VuePerspective vue1;
    private VuePerspective vue2;

    /**
     * Méthode appelée au démarrage de l'application JavaFX.
     * Initialise l'interface graphique, les menus et les vues.
     *
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {

        vueVignette = new VueVignette(imageModele);
        vue1 = new VuePerspective(imageModele, perspective1);
        vue2 = new VuePerspective(imageModele, perspective2);

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(vueVignette, vue1, vue2);
        splitPane.setDividerPositions(0.25, 0.65);

        SplitPane.setResizableWithParent(vueVignette, true);
        SplitPane.setResizableWithParent(vue1, true);
        SplitPane.setResizableWithParent(vue2, true);

        BorderPane root = new BorderPane();
        root.setCenter(splitPane);

        MenuBar menuBar = new MenuBar();

        Menu menuFichier = new Menu("Fichier");
        MenuItem sauvegarder = new MenuItem("Sauvegarder perspective");
        MenuItem charger = new MenuItem("Charger perspective");
        MenuItem chargerImage = new MenuItem("Charger image");
        MenuItem quitter = new MenuItem("Quitter");

        menuFichier.getItems().addAll(sauvegarder, charger, new SeparatorMenuItem(), chargerImage, new SeparatorMenuItem(), quitter);

        Menu menuEdition = new Menu("Édition");
        MenuItem undo = new MenuItem("Annuler");
        MenuItem redo = new MenuItem("Refaire");
        menuEdition.getItems().addAll(undo, redo);

        Menu menuPressePapier = new Menu("Presse-papier");
        MenuItem copierEchelle = new MenuItem("Copier échelle");
        MenuItem copierTranslation = new MenuItem("Copier translation");
        MenuItem copierTout = new MenuItem("Copier tout");
        MenuItem coller = new MenuItem("Coller");
        menuPressePapier.getItems().addAll(copierEchelle, copierTranslation, copierTout, new SeparatorMenuItem(), coller);

        menuBar.getMenus().addAll(menuFichier, menuEdition, menuPressePapier);
        root.setTop(menuBar);

        Scene scene = new Scene(root, 1200, 700);
        stage.setTitle("Laboratoire 5");
        stage.setScene(scene);
        stage.show();

        chargerImage.setOnAction(e -> ouvrirImage());

        quitter.setOnAction(e -> stage.close());
    }

    /**
     * Ouvre une boîte de dialogue permettant de sélectionner une image,
     * puis la charge dans le modèle.
     */
    private void ouvrirImage() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp")
        );
        File fichier = chooser.showOpenDialog(null);
        if (fichier != null) {
            imageModele.chargerImage(fichier.getPath());
            System.out.println("Image chargée : " + fichier.getName());
        }
    }

    /**
     * Méthode utilitaire.
     * @return un conteneur vide
     */
    private Pane createPane() {
        return null;
    }


    /**
     * Point d'entrée de l'application.
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        launch(args);
    }
}