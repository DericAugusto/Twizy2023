
import java.util.List;
import java.util.Arrays;
import org.opencv.core.*;
import org.opencv.highgui.*;
import utilitaireAgreg.MaBibliothequeTraitementImage;
public class Principale {

	public static void main(String[] args)
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Mat imageOriginale=Highgui.imread("/Users/ibrahim/Java_Project/TutoOpenCv/assets/Temoin.png",Highgui.CV_LOAD_IMAGE_COLOR);
		Mat imageTransformee=MaBibliothequeTraitementImage.transformeBGRversHSV(imageOriginale);
		//Mat imageSatureExemple=MaBibliothequeTraitementImage.seuillage_exemple(imageTransformee, 170)
		Mat imageSaturee=MaBibliothequeTraitementImage.seuillage(imageTransformee, 6, 170, 110);
				
		MaBibliothequeTraitementImage.afficheImage("Image originale", imageOriginale);
		//MaBibliothequeTraitementImage.afficheImage("Saturation du rouges exemple", imageSatureExemple);
	
		MaBibliothequeTraitementImage.afficheImage("Saturation des rouges", imageSaturee);
		
		//Ouverture le l'image et saturation des rouges
		Mat m=Highgui.imread("p10.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
		MaBibliothequeTraitementImage.afficheImage("Image test�e", m);
		Mat transformee=MaBibliothequeTraitementImage.transformeBGRversHSV(m);
		//la methode seuillage est ici extraite de l'archivage jar du meme nom 
		Mat saturee=MaBibliothequeTraitementImage.seuillage(transformee, 6, 170, 110);
		Mat objetrond = null;

		//Création d'une liste des contours a partir de l'image saturée
		List<MatOfPoint> ListeContours= MaBibliothequeTraitementImage.ExtractContours(saturee);
		int i=0;
		double [] scores=new double [6];
		//Pour tous les contours de la liste
		for (MatOfPoint contour: ListeContours  ){
			i++;
			objetrond=MaBibliothequeTraitementImage.DetectForm(m,contour);

			if (objetrond!=null){
				MaBibliothequeTraitementImage.afficheImage("Objet rond détecté", objetrond);
				scores[0]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,"ref30.jpg");
				scores[1]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,"ref50.jpg");
				scores[2]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,"ref70.jpg");
				scores[3]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,"ref90.jpg");
				scores[4]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,"ref110.jpg");
				scores[5]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,"refdouble.jpg");


				//recherche de l'index du maximum et affichage du panneau détecté
				double scoremax=-1;
				int indexmax=0;
				for(int j=0;j<scores.length;j++){
					if (scores[j]>scoremax){scoremax=scores[j];indexmax=j;}}	
				if(scoremax<0){System.out.println("Aucun Panneau détecté");}
				else{switch(indexmax){
				case -1:;break;
				case 0:System.out.println("Panneau 30 détecté");break;
				case 1:System.out.println("Panneau 50 détecté");break;
				case 2:System.out.println("Panneau 70 détecté");break;
				case 3:System.out.println("Panneau 90 détecté");break;
				case 4:System.out.println("Panneau 110 détecté");break;
				case 5:System.out.println("Panneau interdiction de dépasser détecté");break;
				}}

			}
		}	


	}
}