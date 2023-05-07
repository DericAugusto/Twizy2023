package tools;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

public class utils {

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

