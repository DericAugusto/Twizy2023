// Exercice 1 : Lecture et affichage d'une image
// slide 11
// 01/03/23

/*
 * lire le ficher et retourner la matrice de l'image;
 * 
 * afficher le contenu de la matrice en mode texte : 
 * pour le blanc le symbole : .
 * pour les autres couleurs : +
 */

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;


public class Exercice1 {

  public static void main(String[] args) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    // Ctrl + D
    String currentDir = System.getProperty("user.dir");
    Mat m = Highgui.imread(currentDir + "\\images\\opencv.png");
    for (int i=0; i < m.height(); i++){
      for (int j=0; j < m.width(); j++){
        double[] BGR = m.get(i, j);
        if (BGR[0] == 255 && BGR[1] == 255 && BGR[1] == 255){
          System.out.print("."); // symbole pour le blanc
        } else {
          System.out.print("+"); // symbole pour les autres couleurs
        }
      }
      System.out.println();
    }
  }


}