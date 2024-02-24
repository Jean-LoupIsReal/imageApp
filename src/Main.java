import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //=============================================TEST SUR IMAGE NOIR ET BLANC======================================================================
        String fileName = "Sherbrooke_Frontenac_nuit";
        String format = "pgm";
        int dimX = 256;
        int dimY = 192;

        File imgFileBW = new File(fileName + "." + format);

        ImageNoirEtBlanc image1 = new ImageNoirEtBlanc(fileName, format, dimX, dimY);

        String newFileName = "newImageBW";

        File newFile = new File(newFileName + "." + format);

        //image1.lire(imgFileBW);

        //test assombrissement image en noir et blanc
        try {
            image1.eclaircir_noircir(0);
        } catch (ExceptionPixelOutOfRange e){
            System.out.println(e);
        }

        image1.ecrire(newFile, image1);

        //affichage de la matrice directement dans le terminal pour test
//        for (int j = 0; j < dimX; j++) {
//            for (int k = 0; k <dimY; k++) {
//                System.out.print(image1.getMatricePixel()[0][0].getTeinte());  //écriture du pixel correspondant au coo
//                System.out.print(" ");      //Séparation de chaque pixel par un espace
//            }
//            System.out.println();       //Retour à la ligne
//        }

//=============================================TEST SUR IMAGE COULEUR======================================================================
        String newFileNameC = "newImageC";
        String format2 = "ppm";
        File newFileC = new File(newFileNameC + "." + format2);

        ImageCouleur image2 = new ImageCouleur(fileName, format);
        image2.setDimX(dimX);       //Pourra être delete quand lire() opérationnel
        image2.setDimY(dimY);       //Pourra être delete quand lire() opérationnel
        image2.ecrire(newFileC, image2);
    }
}