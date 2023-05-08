
import org.opencv.highgui.Highgui;
import org.opencv.core.Core;
import org.opencv.core.Mat;



public class DetectContour {
    public static void main (String []args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String currentDir = System.getProperty("user.dir");
        Mat m = Highgui.imread(currentDir + "assets\\circles_rectangles.jpg");

        MaBibliothequeTraitementImage.afficheImage("Cercles Rectangle",m);
        Mat hsv_image = new Mat();
        hsv_image = MaBibliothequeTraitementImage.transformeBGRversHSV(m);
        MaBibliothequeTraitementImage.afficheImage("Cercles Rectangle HSV",hsv_image);
    }
   
}
