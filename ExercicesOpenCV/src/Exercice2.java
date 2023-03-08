// Exercice 2 : afficher les canaux couleur d'une image
// slide 13
// 01/03/23

/*
 * Afficher dans 3 fenêtres graphiques les 3 composantes couleur de l'image
 * bgr.png : Rouge, Vert et Bleu;
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Vector;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;


public class Exercice2 {

public static void main(String[] args) {
  System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

  String currentDir = System.getProperty("user.dir");
  Mat m = Highgui.imread(currentDir + "\\images\\bgr.png");
  ImShow("Original Image", m);
  
  // vector that stores Mat objects, witch will contain the 
  // RGB components of the image
  Vector<Mat> channels = new Vector<Mat>();
  Core.split(m, channels); // split the three components in a vector


  Vector<String> colour_names = new Vector<String>();
  colour_names.add("Bleu");
  colour_names.add("Vert");
  colour_names.add("Rouge");

  // BGR order
  for (int i=0; i < channels.size(); i++) {
    ImShow(colour_names.get(i), channels.get(i));
  }
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