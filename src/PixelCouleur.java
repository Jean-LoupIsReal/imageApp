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
    public PixelCouleur(RGB couleur) {
        this.setCouleur(couleur);
        this.teinte = 255;
    }
    /**
     * Cette méthode attribut une valeur au pixel
     * @param teinte est la valeur de la couleur / 255
     */
    @Override
    public void setTeinte(int teinte){
        this.teinte = teinte;
        //définit les valeur selon une regle de 3
        this.couleur.setR((this.couleur.getR() * teinte) /255);
        this.couleur.setG((this.couleur.getG() * teinte) /255);
        this.couleur.setB((this.couleur.getB() * teinte) /255);
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
