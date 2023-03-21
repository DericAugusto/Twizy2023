// Exercice 0 : Install and test the OpenCV libraire
// slide 04
// 01/03/23

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Exercice0 {
  public static void main(String[] args){
  
  System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // charger OpenCV
  // cree une matrice identité 3x3 d'une seule dimension : CV_8UC1
  Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
  System.out.println("mat = " + mat.dump());

  }
}