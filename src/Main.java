import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Sherbrooke_Frontenac_nuit";
        String format = "pgm";
        int dimX = 256;
        int dimY = 192;

        File imgFile = new File(fileName + "." + format);

        ImageNoirEtBlanc image1 = new ImageNoirEtBlanc(fileName, format);

        String newFileName = "newImageBW";

        File newFile = new File(newFileName + "." + format);

        //image1.lire(imgFile);
        image1.setDimX(dimX);       //Pourra être delete quand lire() opérationnel
        image1.setDimY(dimY);       //Pourra être delete quand lire() opérationnel
        image1.ecrire(newFile, image1);

        String newFileNameC = "newImageC";
        String format2 = "ppm";
        File newFileC = new File(newFileNameC + "." + format2);

        ImageCouleur image2 = new ImageCouleur(fileName, format);
        image2.setDimX(dimX);       //Pourra être delete quand lire() opérationnel
        image2.setDimY(dimY);       //Pourra être delete quand lire() opérationnel
        image2.ecrire(newFileC, image2);

    }
}