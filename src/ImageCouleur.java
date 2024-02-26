/**
 * Cette classe est la classe fille d'Image
 * @auteur Arthur Andrianjafisolo
 * @autor Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 */

import java.io.*;

public class ImageCouleur extends Image{

    /**
     * Cette methode est un constructeur avec parametre qui prend les valeurs de classe Image et qui est appelee lors de la création d'un nouvel object ImageCouleur
     * @param nomFichier
     * @param format
     * @param matricePixel
     * @param dimX
     * @param dimY
     */
    public ImageCouleur(String nomFichier, String format, Pixel matricePixel[][], int dimX, int dimY) {
        super(nomFichier, format, matricePixel, dimX, dimY);;
    }

    /**
     * Constructeur sans parametre
     */
    public ImageCouleur() {
        this(null,null, null,0,0);
    }

    /**
     * Methode ecrire qui permet de cree une image de couleur
     * @param f Contient un fichier dans lequel l'on va écrire la nouvelle image
     * @param i Contient l'image que l'on desire ecrire dans le fichier f
     * @throws FileNotFoundException dans le cas d'une erreur d'ecrire dans un fichier
     */
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
