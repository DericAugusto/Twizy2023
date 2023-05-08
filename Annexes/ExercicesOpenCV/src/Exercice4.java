// Exercice 4 : Seuillage	d’une	image	par	couleur
// slide 19
// 21/03/23

import org.opencv.core.Core;
import org.opencv.core.Mat;

public class Exercice4 {
  public static void main(String[] args) {
    Solution1();
    //Solution2();
  }

  
  public static void Solution2() {
    // plusieurs seuils

    Mat m = Utils.LectureImage("circles.jpg");

    Mat hsv_image = Utils.BGRversHSV(m);

    Mat threshold_img1 = Utils.appliesSegmentation(hsv_image, 0, 100, 100, 10, 255, 255);
    Mat threshold_img2 = Utils.appliesSegmentation(hsv_image, 160, 100, 100, 179, 255, 255);
    Mat threshold_img = new Mat();
    Core.bitwise_or(threshold_img1, threshold_img2, threshold_img);

    Utils.appliesGaussianBlur(threshold_img, 9, 9, 0, 2, 2);

    Utils.ImShow("Cercles rouges", threshold_img);
  
  }


  public static void Solution1() {
    // un seul seuil

    Mat m = Utils.LectureImage("circles.jpg");

    Mat hsv_image = Utils.BGRversHSV(m);
    Mat threshold_img = Utils.appliesSegmentation(hsv_image, 0, 100, 100, 10, 255, 255);
    Utils.appliesGaussianBlur(threshold_img, 9, 9, 0, 2, 2);

    Utils.ImShow("Cercles rouges", threshold_img);
  }

}
