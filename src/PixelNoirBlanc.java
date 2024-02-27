/**
 * Cette classe PixelCouleurs implemente l'interface Pixel
 * @author Arthur Andrianjafisolo
 * @author Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 * @version 1.0
 */

public class PixelNoirBlanc implements Pixel {
    protected int teinte;

    /**
     * Cette methode est un constructeur avec parametre qui permet de définir la teinte
     * @param teinte
     */
    public PixelNoirBlanc(int teinte){
        setTeinte(teinte);
    }

    /**
     * Cette methode est un constructeur sans parametre qyi defini la teinte a 255
     */
    public PixelNoirBlanc(){
        setTeinte(255);
    }

    /**
     * Cette methode attribut une valeur au pixel
     * @param teinte
     */
    public void setTeinte(int teinte) {
        if(teinte > 255)
            this.teinte = 255;
        if(teinte < 0)
            // a ajouter Exception
            System.out.print("Teinte de PixelNoirBlanc a recu une valeur invalide");
        this.teinte = teinte;
    }

    /**
     * Cette methode retourne la teinte du pixel
     * @return value du Pixel
     */
    public int getTeinte(){
        return this.teinte;
    }

    /**
     * Cette méthode retourne la teinte du pixel
     * @return value du Pixel
     */
    public RGB getCouleur(){
        return new RGB(teinte,teinte,teinte);
    }

    /**
     * Permet d'afficher de manière claire
     * @return les valeurs en string au lieu d'un objet
     */
    public String toString(){return Integer.toString(teinte) +  " ";}
}
