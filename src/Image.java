/**
 * Cette méthode est appelée lors de la création d'un nouvel object Image
 * @auteur Arthur Andrianjafisolo
 * @autor Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 */
import java.io.File;
import java.io.FileNotFoundException;

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
     *
     */
    public Image(String nomFichier, String format) {
        this.nomFichier = nomFichier;
        this.format = format;
        this.dimX = 0;
        this.dimY = 0;
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
     *
     * @param f doit etre un fichier dans lequel l'on va chercher l'information
     * Permet de lire l'information d'un fichier
     */
    public void lire(File f) {}
    /**
     * @param i doit etre une image que l'on desire écrire dans un fichier
     * @param f doit etre un fichier dans lequel l'on va écrire l'information
     */
    public void ecrire(File f, Image i) throws FileNotFoundException {}
    /**
     * @param image1 doit etre une image que l'on desire changer
     * @param image2 doit etre une image que l'on désire dupliquer
     */
    public void copier(Image image1, Image image2){}
    /**
     * @return la valeur ddu pixel qui revient le plus souvent
     */
    public int couleur_predominante(Image i){ return 0; }
    /**
     * @param i Contien l'image de laquel l'on désire extraire une partie
     * @param p1 x du point 1
     * @param c1 y du point 1
     * @param p2 x du point 2
     * @param c2 y du point 2
     * @return un morceau de l'image passé en params sous forme d'une nouvelle image
     */
    public Image extraire(Image i, int p1, int c1, int p2, int c2){ return this;}
    /**
     *
     * Cette fonction réduit la taille de l'image passé en paramettre par 2 puis l'enregistre en nouvelle image
     *
     * @param i représente l'image d'origine
     */
    public void reduire(Image i){}
    /**
     *
     * Cette fonction retourne true si les deux images passé en paramettre sont identiques
     *
     * @param i1 représente l'image 1
     * @param i2 représente l'image 2
     */
    public boolean sont_identiques(Image i1, Image i2){
        return true;
    }
    /**
     *
     * Cette fonction fait une rotation de 90 degrés sur l'image reçus en paramettre puis l'enregistre en nouvelle image
     *
     * @param i représente l'image d'origine
     */
    public void pivoter90(Image i){

    }
}
