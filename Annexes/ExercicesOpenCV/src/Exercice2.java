// Exercice 2 : afficher les canaux couleur d'une image
// slide 13
// 01/03/23

/*
 * Afficher dans 3 fenêtres graphiques les 3 composantes couleur de l'image
 * bgr.png : Rouge, Vert et Bleu;
 */

import java.util.Vector;
import org.opencv.core.Mat;


public class Exercice2 {

public static void main(String[] args) {
  Mat m = Utils.LectureImage("bgr.png");
  Utils.ImShow("Original Image", m);

  Vector<Mat> channels = Utils.splitChannels(m);

  Vector<String> colour_names = new Vector<String>();
  Utils.addRGBnames(colour_names);

  // BGR order
  for (int i=0; i < channels.size(); i++) {
    Utils.ImShow(colour_names.get(i), channels.get(i));
  }
}

}