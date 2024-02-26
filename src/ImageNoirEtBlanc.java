/**
 * Cette classe est la classe fille d'Image
 * @auteur Arthur Andrianjafisolo
 * @autor Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 */
import java.io.*;

public class ImageNoirEtBlanc  extends Image{

    /**
     * Cette methode est un constructeur avec parametre qui prend les valeurs de classe Image et qui est appelee lors de la création d'un nouvel object ImageNoirBlanc
     * @param nomFichier
     * @param format
     * @param matricePixel
     * @param dimX
     * @param dimY
     */
    public ImageNoirEtBlanc(String nomFichier, String format, Pixel matricePixel[][], int dimX, int dimY) {
        super(nomFichier, format, matricePixel, dimX, dimY);
    }

    /**
     * Constructeur sans paramètre
     */
    public ImageNoirEtBlanc() {
        this(null, null, null, 0,0);
    }

    public ImageNoirEtBlanc extraire(ImageNoirEtBlanc i, int p1, int c1, int p2, int c2){
        //Déclare les nouvelle dimmentions de l'image
        int nouvDimX = c2-c1;
        int nouvDimY = p2-p1;
        //Vérifie que les chiffres entrés soient bons
        if(nouvDimY < 0 || nouvDimX < 0)
            //Erreur
            System.out.print("nouvDim négatif dans extraire");
        Pixel[][] matriceTemp= new Pixel[nouvDimY][nouvDimX];
        //Entre les valeurs des pixels dans la matrice temporaire
        for(int y = 0; y < nouvDimY; y++)
        {
            for(int x = 0; x < nouvDimX; x++)
            {
                matriceTemp[y][x] = i.getMatricePixel()[p1 + y][c1 + x];
            }
        }
        //Entre les nouvelles informations dans un nouvel objet
        ImageNoirEtBlanc imageTemp = new ImageNoirEtBlanc(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY );
        return imageTemp;
    }
    public ImageNoirEtBlanc reduire(ImageNoirEtBlanc i){
        int nouvDimX = i.getDimX()/2;
        int nouvDimY = i.getDimY()/2;
        Pixel[][] matriceTemp = new Pixel[nouvDimY][nouvDimX];
        for(int x = 0; x < nouvDimX; x++)
        {
            for(int y = 0; y < nouvDimY; y++)
            {
                matriceTemp[y][x] = i.getMatricePixel()[y][x];
            }
        }
        ImageNoirEtBlanc nouvelleImg = new ImageNoirEtBlanc(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY);
        return nouvelleImg;
    }
    /**
     * Methode ecrire qui permet de cree une image en noir et blanc
     * @param f Contient un fichier dans lequel l'on va écrire la nouvelle image
     * @param i Contient l'image que l'on desire ecrire dans le fichier f
     * @throws FileNotFoundException dans le cas d'une erreur d'ecrire dans un fichier
     */
    @Override
    public void ecrire(File f, Image i) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(f.getName());
            PrintStream ps = new PrintStream(fos);

            ps.println("P2");       //Tons de gris en ASCII
            ps.println(i.getDimX() + " " + i.getDimY());  //Dimmensions de l'image
            ps.println("255");      //valeur max de chaque pixel

            for (int j = 0; j < i.getDimY(); j++) {
                for (int k = 0; k < i.getDimX(); k++) {
                    ps.print(i.getMatricePixel()[j][k].getTeinte());  //écriture du pixel correspondant au coo
                    ps.print(" ");      //Séparation de chaque pixel par un espace
                }
                ps.println();       //Retour à la ligne
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
