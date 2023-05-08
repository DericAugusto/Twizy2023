
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Utils {

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

  public static Mat LectureImage(String nom_image) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    String currentDir = System.getProperty("user.dir");
    Mat m = Highgui.imread(currentDir + "\\assets\\" + nom_image);
    return m;
  }

  public static Vector<Mat> splitChannels(Mat input) {
		Vector<Mat> channels = new Vector<Mat>();
		Core.split(input, channels);
		return channels;
	}

  public static Vector<String> addRGBnames(Vector<String> colour_names){
    colour_names.add("Bleu");
    colour_names.add("Vert");
    colour_names.add("Rouge");
    return colour_names;
  }

  public static Mat BGRversHSV(Mat matriceBGR) {
    // converts image from RGB to HSV 
  
		Mat matriceHSV = new Mat(matriceBGR.size(), matriceBGR.type()); // zeros matrix
		Imgproc.cvtColor(matriceBGR, matriceHSV, Imgproc.COLOR_BGR2HSV); 
		return matriceHSV;
	}
  
  public static Mat appliesSegmentation(Mat image, float va1, float va2, float va3, float vb1, float vb2, float vb3) {
    Mat threshold_img = new Mat();
    Core.inRange(image, new Scalar(va1,va2,va3), new Scalar(vb1,vb2,vb3), threshold_img);
    return threshold_img;
	}

  public static void appliesGaussianBlur(Mat threshold_img, float width, float height, float va3, float sigmaX, float sigmaY) {
    Imgproc.GaussianBlur(threshold_img, threshold_img, new Size(width,height), sigmaX, sigmaY);
	}

}

