/**
 * Cette classe RGB qui permet de définir les 3 pixels necessaire pour avoir la couleur
 * @author Arthur Andrianjafisolo
 * @author Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 * @version 1.0
 */

public class CompteurPixel {
    public int nb;
    public RGB couleur;

    /**
     * Cette methode est un constructeur avec parametre qui compte le nombre de pixels
     * @param nb
     * @param couleur
     */
    CompteurPixel(int nb, RGB couleur){
        this.nb = nb;
        this.couleur = couleur;
    }

}
