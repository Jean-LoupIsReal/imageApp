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
    private Pixel matricePixel[][];
    private int dimX;
    private int dimY;
    /**
     * Cette méthode est appelée lors de la création d'un nouvel object Image
     *
     * @param nomFichier
     * @param format
     * @param dimX
     * @param dimY
     */
    public Image(String nomFichier, String format, Pixel matricePixel[][], int dimX, int dimY) {
        this.nomFichier = nomFichier;
        this.format = format;
        this.dimX = dimX;
        this.dimY = dimY;
        this.matricePixel = matricePixel;
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
    public void setMatricePixel(Pixel matricePixel[][]){this.matricePixel = matricePixel;};
    /**
     * @return la dimention en x de l'object
     */
    public Pixel[][] getMatrixPixel(){return this.matricePixel;}
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
    public void lire(Image i, Files f) {

    }
    /**
     * @param i doit etre une image que l'on desire écrire dans un fichier
     * @param f doit etre un fichier dans lequel l'on va écrire l'information
     */
    public void ecrire(Files f, Image i){}
    /**
     * @param i1 doit etre une image que l'on desire changer
     * @param i2 doit etre une image que l'on désire dupliquer
     */
    public void copier(Image i1, Image i2){
        i1.setDimX(i2.getDimX());
        i1.setDimY(i2.getDimY());
        i1.setFormat(i2.getFormat());
        i1.setNomFichier(i2.getNomFichier());
        i1.setMatricePixel(i2.getMatrixPixel());
    }
    /**
     * @return le pixiel qui revient le plus souvent
     */
    public Pixel couleur_predominante(Image image){ return image.getMatrixPixel()[0][0]; }
    /**
     * @param image Contien l'image de laquel l'on désire extraire une partie
     * @param p1 x du point 1
     * @param c1 y du point 1
     * @param p2 x du point 2
     * @param c2 y du point 2
     * @return le pixiel qui revient le plus souvent
     */
    public Image extraire(Image image, int p1, int c1, int p2, int c2){ return image;}
    /**
     *
     * Cette fonction réduit la taille de l'image passé en paramettre par 2 puis l'enregistre en nouvelle image
     *
     * @param i représente l'image d'origine
     */
    public Image reduire(Image i){
        int nouvDimX = i.getDimX()/2;
        int nouvDimY = i.getDimY()/2;
        Pixel[][] matriceTemp = new Pixel[nouvDimY][nouvDimX];
        for(int x = 0; x < nouvDimX; x++)
        {
            for(int y = 0; y < nouvDimY; y++)
            {
                matriceTemp[y][x] = i.getMatrixPixel()[y][x];
            }
        }
        Image nouvelleImg = new Image(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY);
        return nouvelleImg;
    }
    /**
     *
     * Cette fonction retourne true si les deux images passé en paramettre sont identiques
     *
     * @param i1 représente l'image 1
     * @param i2 représente l'image 2
     */
    public boolean sont_identiques(Image i1, Image i2){
        boolean identique = true;
        // regarde si les images ont la meme grandeur
        identique = identique && (i1.getDimX() == i2.getDimX());
        identique = identique && (i1.getDimY() == i2.getDimY());
        return identique;
    }
    /**
     *
     * Cette fonction fait une rotation de 90 degrés sur l'image reçus en paramettre puis l'enregistre en nouvelle image
     *
     * @param i représente l'image d'origine
     */
    public void pivoter90(Image i){
        Pixel[][] matriceTemp = new Pixel[i.getDimX()][i.getDimY()];
        for(int x = 0; x < i.getDimX(); x++)
        {
            for(int y = 0; y < i.getDimX(); y++)
            {
                matriceTemp[x][y] = i.getMatrixPixel()[y][x];
            }
        }
        i.setMatricePixel(matriceTemp);
    }
}
