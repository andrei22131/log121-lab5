module ca.etsmtl.log121.labo5 {
    requires javafx.controls;

    opens ca.etsmtl.log121.labo5 to javafx.graphics;
    opens ca.etsmtl.log121.labo5.modele;
    opens ca.etsmtl.log121.labo5.vue to javafx.graphics;
    opens ca.etsmtl.log121.labo5.controleur;
    opens ca.etsmtl.log121.labo5.serialisation;

    exports ca.etsmtl.log121.labo5;
    exports ca.etsmtl.log121.labo5.modele;
    exports ca.etsmtl.log121.labo5.vue;
    exports ca.etsmtl.log121.labo5.controleur;
    exports ca.etsmtl.log121.labo5.serialisation;
}
