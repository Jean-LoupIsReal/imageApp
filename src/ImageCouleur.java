import java.io.*;

/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, jean-loup dandurand-pominville
 * @version 1.0
 *
 * Cette classe implemente une ImageCouleur
 */
public class ImageCouleur extends Image{

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object ImageCouleur
     *
     * @param nomFichier
     * @param format
     */
    public ImageCouleur(String nomFichier, String format, Pixel matricePixel[][], int dimX, int dimY) {
        super(nomFichier, format, matricePixel, dimX, dimY);;
    }

    public ImageCouleur() {
        this(null,null, null,0,0);
    }

    @Override
    public void ecrire(File f, Image i) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(f.getName());
            PrintStream ps = new PrintStream(fos);

            ps.println("P3");       //RGB en ASCII
            ps.println(i.getDimX() + " " + i.getDimY());  //Dimmensions de l'image
            ps.println("255");      //valeur max de chaque pixel

            for (int j = 0; j < i.getDimY(); j++) {
                for (int k = 0; k < i.getDimX(); k++) {
                    //ps.print(this.matricePixel[j][k].getValeur());  //écriture du pixel correspondant au coo
                    ps.print("89 56 150");
                    ps.print(" ");      //Séparation de chaque pixel par un espace
                }
                ps.println();       //Retour à la ligne
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
