package ca.etsmtl.log121.labo5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ApplicationPrincipale extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

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

        Pane thumbnailPane = createPane();
        Pane view1Pane = createPane();
        Pane view2Pane = createPane();

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(thumbnailPane, view1Pane, view2Pane);

        splitPane.setDividerPositions(0.33, 0.66);

        SplitPane.setResizableWithParent(thumbnailPane, true);
        SplitPane.setResizableWithParent(view1Pane, true);
        SplitPane.setResizableWithParent(view2Pane, true);

        root.setCenter(splitPane);

        Scene scene = new Scene(root, 900, 500);
        stage.setTitle("Laboratoire 5");
        stage.setScene(scene);
        stage.show();

        quitter.setOnAction(e -> {
            System.exit(0);
        });
    }

    private Pane createPane() {
        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: blue; -fx-border-width: 2px; -fx-background-color: lightgray;");
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
