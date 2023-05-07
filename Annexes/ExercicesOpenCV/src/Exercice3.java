// Exercice 3 : passage	de	BGR	à	HSV
// slide 17
// 21/03/23

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
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
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Exercice3 {
  public static void main(String[] args) {

    // read image
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    String currentDir = System.getProperty("user.dir");
    Mat m = Highgui.imread(currentDir + "\\images\\hsv.png");

    // creating zeroes matrix
    Mat output = Mat.zeros(m.size(), m.type());

    // applies a color conversion function from the Imgproc class
    // RGB to HSV and stores it to "output"
    Imgproc.cvtColor(m, output, Imgproc.COLOR_BGR2HSV);
    ImShow("HSV", output);

    Vector<Mat> channels = new Vector<Mat>();
    Core.split(output, channels);

    double hvs_values[][] = {{1, 255, 255}, {179, 1, 255}, {179, 0, 1}};

    for (int i=0; i < 3; i++) {
      ImShow(Integer.toString(i) + "-HSV", channels.get(i));

      // array with the pixel values of the 3 image channels 
      Mat chans[] = new Mat[3];

      for (int j=0; j < 3; j++) {

        // stores pixel values in an 8-bit unsigned integer format
        Mat empty = Mat.ones(m.size(), CvType.CV_8UC1);
        Mat comp = Mat.ones(m.size(), CvType.CV_8UC1);

        Scalar v = new Scalar(hvs_values[i][j]);

        // comp = empty * v 
        // (multiplies each pixel value in "empty" by the corresponding value in "v")
        Core.multiply(empty, v, comp);

        chans[j] = comp;
      }
      chans[i] = channels.get(i);
      Mat dst = Mat.zeros(output.size(), output.type());
      Mat res = Mat.ones(dst.size(), dst.type());

      Core.merge(Arrays.asList(chans), dst);

      Imgproc.cvtColor(dst, res, Imgproc.COLOR_HSV2BGR);
      ImShow(Integer.toString(i), res);
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
