// Exercice 3 : passage	de	BGR	à	HSV
// slide 17
// 21/03/23

import java.util.Arrays;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Exercice3 {
  public static void main(String[] args) {

    Mat m = Utils.LectureImage("hsv.png");

    // creating zeroes matrix
    Mat output = Mat.zeros(m.size(), m.type());

    // applies a color conversion function from the Imgproc class
    // RGB to HSV and stores it to "output"
    Imgproc.cvtColor(m, output, Imgproc.COLOR_BGR2HSV);
    Utils.ImShow("HSV", output);

    Vector<Mat> channels = Utils.splitChannels(m);

    double hvs_values[][] = {{1, 255, 255}, {179, 1, 255}, {179, 0, 1}};

    for (int i=0; i < 3; i++) {
      Utils.ImShow(Integer.toString(i) + "-HSV", channels.get(i));

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
      Utils.ImShow(Integer.toString(i), res);
    }
  }

}
