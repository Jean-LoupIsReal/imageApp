import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //==================Test noir et blanc====================================

        String fileName = "Sherbrooke_Frontenac_nuit";
        String formatBW = "pgm";
        Image test = new Image();
        File imgFileBW = new File(fileName + "." + formatBW);

        File newImgFileBW = new File(fileName + "BW." + formatBW);

        ImageNoirEtBlanc newImgBW = new ImageNoirEtBlanc();

        test.lire(imgFileBW);        //Fonctionne

        newImgBW.ecrire(newImgFileBW, test);        //Fonctionne

        System.out.println("La couleur principale de l'image en noir et blanc est: " + test.couleur_predominante(test).toString());        //Fonctionne
        //==================Test couleur====================================
        String formatC = "ppm";
        Image test2 = new Image();
        File imgFileC = new File(fileName + "." + formatC);

        File newImgFileC = new File(fileName + "C." + formatC);

        ImageCouleur newImgC = new ImageCouleur();

        test2.lire(imgFileC);        //Fonctionne

        newImgC.ecrire(newImgFileC, test2);        //Fonctionne

        System.out.println("La couleur principale de l'image couleur  est: " + test2.couleur_predominante(test2).toString());        //Fonctionne
    }
}