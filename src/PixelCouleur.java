/**
 * Cette classe PixelCouleurs implemente l'interface Pixel
 * @author Arthur Andrianjafisolo
 * @author Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 * @version 1.0
 */
import java.io.*;

public class PixelCouleur implements Pixel {
    private RGB couleur;
    int teinte;

    /**
     * Cette methode est un constructeur avec paramètre qui appel la classe RGB pour definir la couleur et mets la teinte a 255
     * @param couleur provient de la classe RGB
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
        //définit les valeurs selon une règle de 3
        this.couleur.setR((this.couleur.getR() * teinte) /255);
        this.couleur.setG((this.couleur.getG() * teinte) /255);
        this.couleur.setB((this.couleur.getB() * teinte) /255);
    }

    /**
     * Cette methode retourne la teinte du pixel
     * @return la teinte du Pixel
     */
    @Override
    public int getTeinte() {
        return 0;
    }

    /**
     * Cette methode attribut une valeur au pixel
     * @param couleur
     */
    public void setCouleur(RGB couleur) {
        this.couleur = couleur;
    }

    /**
     * Cette methode retourne la couleur du pixel
     * @return value du Pixel
     */
    @Override
    public RGB getCouleur(){
        return this.couleur;
    }

    /**
     * Permet d'afficher de manière claire
     * @return les valeurs en string au lieu d'un objet
     */
    public String toString(){
        return this.couleur.toString();
    }
}
