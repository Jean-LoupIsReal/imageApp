/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, Jean-Loup Dandurand-Pominville
 * @version 1.0
 *
 * Cette classe est la classe fille de Pixel et elle implémente les pixels en noir et blanc
 */
public class PixelNoirBlanc implements Pixel {
    protected int teinte;

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
        setTeinte(0);
    }
    /**
     * Cette méthode attribut une valeur au pixel
     * @param teinte
     */
    public void setTeinte(int teinte) {
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
        if(this.teinte > 255)
            return 255;
        return this.teinte;
    }
    /**
     * Cette méthode retourne la luminosite du pixel
     * @return value du Pixel
     */
    public RGB getCouleur(){
        return new RGB(this.teinte, this.teinte, this.teinte);
    }
    /**public void ecrire(out){
        out(teinte)
    }*/
}
