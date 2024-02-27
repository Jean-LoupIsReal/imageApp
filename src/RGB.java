/**
 * Cette classe RGB qui permet de définir les 3 pixels necessaire pour avoir la couleur
 * @author Arthur Andrianjafisolo
 * @author Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 * @version 1.0
 */

public class RGB {
    private int R;
    private int G;
    private int B;

    /**
     * Cette methode est un constructeur avec parametre RGB qui permet de définir les 3 pixels
     * @param r
     * @param g
     * @param b
     */
    public RGB(int r, int g, int b){
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }

    /**
     * Cette methode retourne la couleur du pixel Rouge
     * @return la valeur de Rouge
     */
    public int getR() {

        if(R > 255)
            return 255;
        return R;
    }

    /**
     * Cette methode retourne la couleur du pixel Vert
     * @return la valeur de Vert
     */
    public int getG() {

        if(G > 255)
            return 255;
    return G;
    }

    /**
     * Cette methode retourne la couleur du pixel Bleu
     * @return la valeur de Bleu
     */
    public int getB() {
        if(B > 255)
            return 255;
        return B;
    }

    /**
     * Cette methode attribut une valeur a la classe
     * @param r est la couleur en rouge
     */
    public void setR(int r) {
        if (r < 0)
            //ajouter Exception
            System.out.print("G de rgb a recu une valeur invalide");
        R = r;
    }

    /**
     * Cette methode attribut une valeur a la classe
     * @param g est la couleur en vert
     */
    public void setG(int g) {
        if (g < 0)
            // ajouter Exception
            System.out.print("G de rgb a recu une valeur invalide");
        G = g;
    }

    /**
     * Cette methode attribut une valeur a la classe
     * @param b est la couleur en bleu
     */
    public void setB(int b) {
        if (b < 0)
            // ajouter Exception
            System.out.print("B de rgb a recu une valeur invalide");
        B = b;
    }

    /**
     * Cette methode permet de comparer si les pixels RGB sont identiques
     * @param rgb
     * @return true si la valeur est identique
     */
    public boolean compare(RGB rgb){
        boolean identique = true;
        identique = identique && this.getR() == rgb.getR();
        identique = identique && this.getG() == rgb.getG();
        identique = identique && this.getB() == rgb.getB();
        return identique;
    }

    /**
     * Permet d'afficher de manière claire
     * @return les valeurs en string au lieu d'un objet
     */
    public String toString(){
        return Integer.toString(R) + " " + Integer.toString(G) + " " + Integer.toString(B) + " ";
    }
}
