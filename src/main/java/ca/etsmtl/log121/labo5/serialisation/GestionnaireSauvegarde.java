package ca.etsmtl.log121.labo5.serialisation;

import java.io.*;

//gère la sérialisation/désérialisation de l'état de l'application sur disque
public class GestionnaireSauvegarde {

    public static void sauvegarder(DonneesSauvegarde donnees, File fichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(donnees);
        }
    }

    public static DonneesSauvegarde charger(File fichier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            return (DonneesSauvegarde) ois.readObject();
        }
    }
}
