public class Pixel {
    private int valeur;

    /**
     *Cette méthode est appelée lors de la création d'un nouvel object Image
     * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
     * @version 1.0
     * @param valeur
     */

    //Constructeur avec paramètre
    public Pixel(int valeur) {
        this.valeur = valeur;
    }

    //Constructeur sans paramètre
    public Pixel(){
        this(0);
    }

    /**
     * Cette méthode retourne la valeur du pixel
     * @return value du Pixel
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Cette méthode attribut une valeur au pixel
     * @param valeur
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
