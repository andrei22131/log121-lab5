package ca.etsmtl.log121.labo5.serialisation;

import java.io.*;

//gère la sérialisation/désérialisation de l'état de l'application sur disque
public class GestionnaireSauvegarde {

    /**
     * Sauvegarde les données dans un fichier.
     * @param donnees données à sauvegarder
     * @param fichier fichier de destination
     * @throws IOException en cas d'erreur d'écriture
     */
    public static void sauvegarder(DonneesSauvegarde donnees, File fichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(donnees);
        }
    }

    /**
     * Charge les données depuis un fichier.
     * @param fichier fichier source
     * @return données chargées
     * @throws IOException en cas d'erreur de lecture
     * @throws ClassNotFoundException si la classe n'est pas trouvée
     */
    public static DonneesSauvegarde charger(File fichier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            return (DonneesSauvegarde) ois.readObject();
        }
    }
}