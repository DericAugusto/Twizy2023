// Exercice 4 : Seuillage	d’une	image	par	couleur
// slide 19
// 21/03/23

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Vector;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Exercice4 {
  public static void main(String[] args) {
    //Solution1();

    Solution2();

  }

  public static void Solution2() {

    Mat m = LectureImage("circles.jpg");

    // zeros matrix
    Mat hsv_image = Mat.zeros(m.size(), m.type());

    // converts image from RGB to HSV 
    Imgproc.cvtColor(m, hsv_image, Imgproc.COLOR_BGR2HSV);

    // applies a segmentation to the image
    Mat threshold_img1 = new Mat();
    Mat threshold_img2 = new Mat();
    Mat threshold_img = new Mat();
    Core.inRange(hsv_image, new Scalar(0,100,100), new Scalar(10, 255,255), threshold_img1);
    Core.inRange(hsv_image, new Scalar(160,100,100), new Scalar(179, 255,255), threshold_img2);

    // applies a Gaussian Blur to the image
    Imgproc.GaussianBlur(threshold_img, threshold_img, new Size(9, 9), 2, 2);
    ImShow("Cercles rouges", threshold_img);
  
  }

  public static void Solution1() {
    Mat m = LectureImage("circles.jpg");

    // zeros matrix
    Mat hsv_image = Mat.zeros(m.size(), m.type());

    // converts image from RGB to HSV 
    Imgproc.cvtColor(m, hsv_image, Imgproc.COLOR_BGR2HSV);

    // applies a segmentation to the image
    Mat threshold_img = new Mat();
    Core.inRange(hsv_image, new Scalar(0,100,100), new Scalar(10,255,255), threshold_img);

    // applies a Gaussian Blur to the image
    Imgproc.GaussianBlur(threshold_img, threshold_img, new Size(9,9), 2, 2);
    ImShow("Cercles rouges", threshold_img);
  }

  public static Mat LectureImage(String nom_image) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    String currentDir = System.getProperty("user.dir");
    Mat m = Highgui.imread(currentDir + "\\images\\" + nom_image);
    return m;
  }

  public static void ImShow(String title, Mat img) {

    // class used to store and manipulate binary image data (part of OpenCV module)
    MatOfByte matOfByte = new MatOfByte();

    // class for reading displaying and saving images
    Highgui.imencode(".png", img, matOfByte);
    byte[] byteArray = matOfByte.toArray();

    // provides methods to create, manipulate ad get pixel data from images
    BufferedImage bufImage = null;
    try {
      // create a input stream that reads the byte array
      InputStream in = new ByteArrayInputStream(byteArray);

      // reads the image from the input stream and converts into a buffered image
      // object representing the image
      bufImage = ImageIO.read(in);

      // uses the frame library to print the image
      JFrame frame = new JFrame();
      frame.setTitle(title);
      frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
      frame.pack();
      frame.setVisible(true);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
