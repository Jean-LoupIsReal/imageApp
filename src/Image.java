import java.nio.file.Files;

public class Image {
    private String nomFichier;
    private  String format;

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object Image
     *
     * @param nomFichier
     * @param format
     */
    public Image(String nomFichier, String format) {
        this.nomFichier = nomFichier;
        this.format = format;
    }

    /**
     * @return nomFichier
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     * @param nomFichier
     */
    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    /**
     * @return format de l'object
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }
    public void lire(Image i, Files f) {}
}
