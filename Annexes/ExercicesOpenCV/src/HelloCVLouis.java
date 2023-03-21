//package twizy2023;
//import java.util.Arrays;
//import java.util.Vector;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfInt4;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;


public class HelloCVLouis {

    public static void main(String[] args) {
        // changer la bibliothèque native d'OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
            
        // la classe Mat stoque des matrices, images, vecteurs, ...
        Mat m = Highgui.imread("C:\\Users\\deric\\Desktop\\OpenCV\\images\\circles_rectangles.jpg");
        Mat hsv_image = Mat.zeros(m.size(), m.type()); 
        Imgproc.cvtColor(m, hsv_image, Imgproc.COLOR_BGR2HSV);
        ImShow("HSV", hsv_image);
        Mat treshold_img = DetecterRouge(m);
        
        List<MatOfPoint> contours = DetecterContours(treshold_img);
        System.out.println(contours);

        Mat mCircles = RecognizeRedCircles(contours,m);
        ImShow("Détection des cercles rouges", mCircles);
        
    }

    public static void ImShow(String title, Mat img) { 
        MatOfByte matOfByte = new MatOfByte();
        Highgui.imencode(".png", img, matOfByte);
        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
            JFrame frame = new JFrame();
            frame.setTitle(title);
            frame.getContentPane().add(new JLabel (new ImageIcon(bufImage)));
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Mat DetecterRouge(Mat m){
        Mat hsv_image = Mat.zeros(m.size(), m.type());
        Imgproc.cvtColor(m, hsv_image, Imgproc.COLOR_BGR2HSV);
        Mat threshold_img1 = new Mat();
        Mat threshold_img = new Mat();
        Mat threshold_img2 = new Mat();
        Core.inRange(hsv_image, new Scalar(0,100,100), new Scalar(10,255,255), threshold_img1);
        Core.inRange(hsv_image, new Scalar(160,100,100), new Scalar(179,255,255), threshold_img2);
        Core.bitwise_or(threshold_img1, threshold_img2, threshold_img);
        Imgproc.GaussianBlur(threshold_img, threshold_img, new Size(9,9),2 ,2);
        //ImShow("Cercles rouge", threshold_img);
        return threshold_img;
    }   

    public static List<MatOfPoint> DetecterContours(Mat threshold_img){
        int tresh = 100;
        Mat canny_output = new Mat();
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        MatOfInt4 hierarchy = new MatOfInt4();
        Imgproc.Canny(threshold_img, canny_output, tresh, tresh*2);
        Imgproc.findContours(canny_output, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        Mat drawing = Mat.zeros(canny_output.size(), CvType.CV_8UC3);
        Random rand = new Random();
        for (int i = 0; i < contours.size(); i++) {
            Scalar color = new Scalar(rand.nextInt(255-0+1),rand.nextInt(255-0+1),rand.nextInt(255-0+1));
            Imgproc.drawContours(drawing,contours, i, color, 1,8,hierarchy,0,new Point());
        }
        ImShow("Contours", drawing);
        return contours;
    }

    public static Mat RecognizeRedCircles(List<MatOfPoint> contours,Mat m){

        MatOfPoint2f matOfPoint2f = new MatOfPoint2f();
        float[] radius = new float[1];
        Point center = new Point();
        for (int c = 0; c < contours.size(); c++) {
            MatOfPoint contour = contours.get(c);
            double contourArea = Imgproc.contourArea(contour);
            matOfPoint2f.fromList(contour.toList());
            Imgproc.minEnclosingCircle(matOfPoint2f, center, radius);
            if (contourArea/(Math.PI*radius[0]*radius[0]) >= 0.8) {
                Core.circle(m, center, (int)radius[0],new Scalar(0,255,0), 2);
            }
        }
        return m;
        
    }

    public static void extractRedBalls(){
        
    }
}

