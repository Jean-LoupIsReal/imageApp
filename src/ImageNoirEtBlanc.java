import java.io.*;

/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, jean-loup dandurand-pominville
 * @version 1.0
 *
 * Cette classe implemente une ImageNoirEtBlanc
 */
public class ImageNoirEtBlanc  extends Image{
    private PixelNoirBlanc matricePixel[][];

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object ImageNoirEtBlanc
     *
     * @param nomFichier
     * @param format
     */
    public ImageNoirEtBlanc(String nomFichier, String format) {
        super(nomFichier, format);
    }

    /**
     *
     * TODO: Remove this constructor. Was create for test
     *
     * @param nomFichier
     * @param format
     * @param dimX
     * @param dimY
     */
    public ImageNoirEtBlanc(String nomFichier, String format, int dimX, int dimY) {
        super(nomFichier, format);
        this.setDimX(dimX);
        this.setDimY(dimY);

        this.matricePixel = new PixelNoirBlanc[this.getDimX()][];

        // Initialize the inner arrays for each row
        for (int j = 0; j < this.getDimX(); j++) {
            matricePixel[j] = new PixelNoirBlanc[this.getDimY()];
        }

        //Initialisation de la matrice tant que lire() non fonctionnel
        for (int j = 0; j < this.getDimX(); j++) {
            for (int k = 0; k < this.getDimY(); k++) {
                matricePixel[j][k] = new PixelNoirBlanc();

                matricePixel[j][k].setTeinte(89);  //écriture du pixel correspondant au coo
            }
        }
    }

    /**
     *
     * Cette fonctionne change suivant si l'image est en couleur ou en noir et blanc
     *
     * @param f doit etre un fichier dans lequel l'on va écrire l'image
     * @param i doit etre une image que l'on desire écrire dans un fichier
     * @throws FileNotFoundException dans le cas d'une erreur de d'écriture dans fichier
     */
    @Override
    public void ecrire(File f, Image i) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(f.getName());
            PrintStream ps = new PrintStream(fos);

            ps.println("P2");       //Tons de gris en ASCII
            ps.println(i.getDimX() + " " + i.getDimY());  //Dimmensions de l'image
            ps.println("255");      //valeur max de chaque pixel

            for (int j = 0; j < i.getDimX(); j++) {
                for (int k = 0; k < i.getDimY(); k++) {
                    ps.print(i.getMatricePixel()[j][k].getTeinte());  //écriture du pixel correspondant au coo
                    ps.print(" ");      //Séparation de chaque pixel par un espace
                }
                ps.println();       //Retour à la ligne
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * @return matricePixel
     */
    public PixelNoirBlanc[][] getMatricePixel() {
        return this.matricePixel;
    }

    /**
     * @param matricePixel
     */
    public void setMatricePixel(PixelNoirBlanc[][] matricePixel) {
        this.matricePixel = matricePixel;
    }

    /**
     * Cette fonction sert à augmenter/ réduire la valeur de chacun des pixels présent dans l'image en question, si v est positif l'image s'éclaircie, si v est négatif l'image s'assombrie
     *
     * @param v valeur à ajouter/ déduire de la valeur de chaque pixel de l'image suivant si elle est +/-
     *
     * Testé et fonctionnel le 24/02/2024 à 18h23
     */
    public void eclaircir_noircir(int v) throws ExceptionPixelOutOfRange {
        for (int j = 0; j < this.getDimX(); j++) {
            for (int k = 0; k < this.getDimY(); k++) {
                int newPixelVal = this.getMatricePixel()[j][k].getTeinte() + v;

                //Si newPixelVal est comprise entre 0 et 255, on peut changer la teinte du pixel
                if (newPixelVal >= 0 && newPixelVal <= 255)
                    this.matricePixel[j][k].setTeinte(newPixelVal);
                else    //Sinon on retourne une erreur
                    throw new ExceptionPixelOutOfRange("La valeur d'un pixel doit être comprise entre 0 et 255!");
            }
        }
    }
}
