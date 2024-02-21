/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
 * @version 1.0
 *
 * Cette classe est la classe fille de Pixel et elle implémente les pixels de couleur
 */
public class PixelCouleur extends PixelNoirBlanc{
    private RGB couleur;

    /**
     *Cette méthode est appelée lors de la création d'un nouvel object Image
     * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
     * @version 1.0
     * @param couleur
     */
    public PixelCouleur(RGB couleur){
        setCouleur(couleur);
    }
    /**
     * Cette méthode attribut une valeur au pixel
     * @param couleur
     */
    public void setCouleur(RGB couleur) {
        this.couleur = couleur;
    }
    /**
     * Cette méthode retourne la luminosite du pixel
     * @return value du Pixel
     */
    @Override
    public RGB getCouleur(){
        return this.couleur;
    }


}
