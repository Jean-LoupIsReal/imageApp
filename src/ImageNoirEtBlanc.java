/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, jean-loup dandurand-pominville
 * @version 1.0
 *
 * Cette classe implemente une ImageNoirEtBlanc
 */
public class ImageNoirEtBlanc  extends Image{
    private PixelNoiretBlanc matricePixel[][];

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object ImageNoirEtBlanc
     *
     * @param nomFichier
     * @param format
     */
    public ImageNoirEtBlanc(String nomFichier, String format, PixelNoiretBlanc[][] matricePixel) {
        super(nomFichier, format);
        this.matricePixel = matricePixel;
    }

    /**
     * @return matricePixel
     */
    public PixelNoiretBlanc[][] getMatricePixel() {
        return matricePixel;
    }

    /**
     * @param matricePixel
     */
    public void setMatricePixel(PixelNoiretBlanc[][] matricePixel) {
        this.matricePixel = matricePixel;
    }
}
