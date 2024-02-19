/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, jean-loup dandurand-pominville
 * @version 1.0
 *
 * Cette classe implemente une ImageNoirEtBlanc
 */
public class ImageNoirEtBlanc  extends Image{
    private PixelNoirBlanc matricePixel[][];

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object ImageNoirEtBlanc
     *
     * @param nomFichier
     * @param format
     */
    public ImageNoirEtBlanc(String nomFichier, String format, PixelNoirBlanc[][] matricePixel) {
        super(nomFichier, format);
        this.matricePixel = matricePixel;
    }

    /**
     * @return matricePixel
     */
    public PixelNoirBlanc[][] getMatricePixel() {
        return matricePixel;
    }

    /**
     * @param matricePixel
     */
    public void setMatricePixel(PixelNoirBlanc[][] matricePixel) {
        this.matricePixel = matricePixel;
    }
}
