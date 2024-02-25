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
        setTeinte(255);
    /**
     * Cette méthode attribut une valeur au pixel
     * @param teinte est la valeur de la couleur / 255
     */
    @Override
    public int setTeinte(int teinte){
        this.teinte = teinte;
        //définit les valeur selon une regle de 3
        this.couleur.setR((this.couleur.R * teinte) /255);
        this.couleur.setG((this.couleur.G * teinte) /255);
        this.couleur.setB((this.couleur.B * teinte) /255);

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
    /**public void ecrire(out){
        couleur.ecrir(out)
     }*/
}
