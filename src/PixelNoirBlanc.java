/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
 * @version 1.0
 *
 * Cette classe est la classe fille de Pixel et elle implémente les pixels en noir et blanc
 */
public class PixelNoirBlanc implements Pixel {
    private int luminosite;

    /**
     *Cette méthode est appelée lors de la création d'un nouvel object Image
     * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
     * @version 1.0
     * @param luminosite
     */
    public PixelNoirBlanc(int luminosite){
        setLuminosite(luminosite);
    }
    public PixelNoirBlanc(){
        setLuminosite(0);
    }
    /**
     * Cette méthode attribut une valeur au pixel
     * @param luminosite
     */
    public void setLuminosite(int luminosite) {
        if(luminosite < 0 || luminosite > 255)
            // a ajouter Exception
            System.out.print("luminosite de PixelNoirBlanc a recu une valeur invalide");
        this.luminosite = luminosite;
    }
    /**
     * Cette méthode retourne la luminosite du pixel
     * @return value du Pixel
     */
    public int getLuminosite(){
        return this.luminosite;
    }
    /**
     * Cette méthode retourne la luminosite du pixel
     * @return value du Pixel
     */
    public RGB getCouleur(){
        return new RGB(255,255,255);
    }
}
