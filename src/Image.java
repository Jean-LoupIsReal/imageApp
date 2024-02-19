/**
 * Cette méthode est appelée lors de la création d'un nouvel object Image
 * @auteur Arthur Andrianjafisolo
 * @autor Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 */
import java.nio.file.Files;

public class Image {

    private String nomFichier;
    private  String format;
    private int dimX;
    private int dimY;

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object Image
     *
     * @param nomFichier
     * @param format
     * @param matricePixel
     * @param dimX
     * @param dimY
     */
    public Image(String nomFichier, String format, Pixel[][] matricePixel, int dimX, int dimY) {
        this.nomFichier = nomFichier;
        this.format = format;
        this.dimX = dimX;
        this.dimY = dimY;
    }

    /**
     * @return nomFichier
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     * @param nomFichier doit etre une string
     */
    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    /**
     * @return format de l'object
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }
    /**
     * @return la dimention en x de l'object
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * @param dimX doit prendre une dimention en int pour la longueur en x
     */
    public void setDimX(int dimX) {
        this.dimX = dimX;
    }
    /**
     * @return la dimention en y de l'object
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * @param dimY doit prendre une dimention en int pour la hauteur en y
     */
    public void setDimY(int dimY) {
        this.dimY = dimY;
    }
    /**
     * @param i doit etre une image que l'on desire lire
     * @param f doit etre un fichier dans lequel l'on va chercher l'information
     * Permet de lire l'information d'un fichier
     */
    public void lire(Image i, Files f) {}
    /**
     * @param i doit etre une image que l'on desire écrire dans un fichier
     * @param f doit etre un fichier dans lequel l'on va écrire l'information
     */
    public void ecrire(Files f, Image i){}
    /**
     * @param image1 doit etre une image que l'on desire changer
     * @param image2 doit etre une image que l'on désire dupliquer
     */
    public void copier(Image image1, Image image2){}
    /**
     * @return le pixiel qui revient le plus souvent
     */
    public Pixel couleur_predominante(Image i){ return i.getMatrixPixel()[0][0]; }
    /**
     * @param i Contien l'image de laquel l'on désire extraire une partie
     * @param p1 x du point 1
     * @param c1 y du point 1
     * @param p2 x du point 2
     * @param c2 y du point 2
     * @return le pixiel qui revient le plus souvent
     */
    public Image extraire(Image i, int p1, int c1, int p2, int c2){ return img;}
    /**
     *
     */
    public void reduire(Image i){}
    /**
     *
     */
    public void sont_identiques(Image i1, Image i2){}
    /**
     *
     */
    public void pivoter90(Image i){}
}
