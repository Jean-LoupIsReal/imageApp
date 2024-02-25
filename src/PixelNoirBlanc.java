/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
 * @version 1.0
 *
 * Cette classe est la classe fille de Pixel et elle implémente les pixels en noir et blanc
 */
public class PixelNoirBlanc implements Pixel {
    private int teinte;

    /**
     *Cette méthode est appelée lors de la création d'un nouvel object Image
     * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
     * @version 1.0
     * @param luminosite
     */
    public PixelNoirBlanc(int luminosite){
        setTeinte(luminosite);
    }
    public PixelNoirBlanc(){
        setTeinte(255);
    }
    /**
     * Cette méthode attribut une valeur au pixel
     * @param teinte
     */
    public void setTeinte(int teinte) {
        if(teinte > 255)
            this.teinte = 255;
        if(teinte < 0)
            // a ajouter Exception
            System.out.print("luminosite de PixelNoirBlanc a recu une valeur invalide");
        this.teinte = teinte;
    }
    /**
     * Cette méthode retourne la luminosite du pixel
     * @return value du Pixel
     */
    public int getTeinte(){
        return this.teinte;
    }
    /**
     * Cette méthode retourne la luminosite du pixel
     * @return value du Pixel
     */
    public RGB getCouleur(){
        return new RGB(teinte,teinte,teinte);
    }
    /**public void ecrire(out){
        out(teinte)
    }*/
}
