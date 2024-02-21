/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, jean-loup dandurand-pominville
 * @version 1.0
 *
 * Cette classe implemente une ImageCouleur
 */
public class ImageCouleur extends Image{
    private PixelCouleur matricePixel[][];

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object ImageCouleur
     *
     * @param nomFichier
     * @param format
     * @param matricePixel
     */
    public ImageCouleur(String nomFichier, String format, PixelCouleur[][] matricePixel) {
        super(nomFichier, format);
        this.matricePixel = matricePixel;
    }

    /**
     * @return matricePixel
     */
    public PixelCouleur[][] getMatricePixel() {
        return matricePixel;
    }

    /**
     * @param matricePixel
     */
    public void setMatricePixel(PixelCouleur[][] matricePixel) {
        this.matricePixel = matricePixel;
    }


}
