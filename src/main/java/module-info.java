module ca.etsmtl.log121.labo5 {
    requires javafx.controls;
    requires javafx.swing;

    opens ca.etsmtl.log121.labo5 to javafx.graphics;
    opens ca.etsmtl.log121.labo5.modele;
    opens ca.etsmtl.log121.labo5.vue to javafx.graphics;
    opens ca.etsmtl.log121.labo5.commande;
    opens ca.etsmtl.log121.labo5.serialisation;

    exports ca.etsmtl.log121.labo5;
    exports ca.etsmtl.log121.labo5.modele;
    exports ca.etsmtl.log121.labo5.vue;
    exports ca.etsmtl.log121.labo5.commande;
    exports ca.etsmtl.log121.labo5.serialisation;
}
