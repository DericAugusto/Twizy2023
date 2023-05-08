// Exercice 2 : afficher les canaux couleur d'une image (colorée)
// slide 13
// 01/03/23

/*
 * Afficher dans 3 fenêtres graphiques les 3 composantes couleur de l'image
 * bgr.png : Rouge, Vert et Bleu;
 */

import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class Exercice2b {

public static void main(String[] args) {

  Mat m = Utils.LectureImage("bgr.png");

  Utils.ImShow("Original Image", m);
  
  Vector<Mat> channels = Utils.splitChannels(m);

  Mat dst = Mat.zeros(m.size(), m.type());
  Vector<Mat> chans = new Vector<Mat>();
  // create a matrix of 8-bit unsigned integers with a single channel elements
  Mat empty = Mat.zeros(m.size(), CvType.CV_8UC1);

  // adding names for the images
  Vector<String> colour_names = new Vector<String>();
  Utils.addRGBnames(colour_names);
  
  // BGR order
  for (int i=0; i < channels.size(); i++) {
    //ImShow(colour_names.get(i), channels.get(i));

    chans.removeAllElements();

    for (int j=0; j < channels.size(); j++)
    {
      if (j != i) 
      {
        chans.add(empty);
      } else {
        chans.add(channels.get(i));
      }
    }
    Core.merge(chans, dst);
    Utils.ImShow(colour_names.get(i), dst);
  }
}

}