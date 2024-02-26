import java.io.*;

/**
 *
 * @author Audy Altis, Arthur Andrianjafisolo, jean-loup dandurand-pominville
 * @version 1.0
 *
 * Cette classe implemente une ImageCouleur
 */
public class ImageCouleur extends Image{

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object ImageCouleur
     *
     * @param nomFichier
     * @param format
     */
    public ImageCouleur(String nomFichier, String format, Pixel matricePixel[][], int dimX, int dimY) {
        super(nomFichier, format, matricePixel, dimX, dimY);;
    }

    public ImageCouleur() {
        this(null,null, null,0,0);
    }
    public ImageCouleur extraire(ImageCouleur i, int p1, int c1, int p2, int c2){
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
        ImageCouleur imageTemp = new ImageCouleur(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY );
        return imageTemp;
    }
    public ImageCouleur reduire(Image i){
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
        ImageCouleur nouvelleImg = new ImageCouleur(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY);
        return nouvelleImg;
    }

    @Override
    public void ecrire(File f, Image i) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(f.getName());
            PrintStream ps = new PrintStream(fos);

            ps.println("P3");       //RGB en ASCII
            ps.println(i.getDimX() + " " + i.getDimY());  //Dimmensions de l'image
            ps.println("255");      //valeur max de chaque pixel

            for (int j = 0; j < i.getDimY(); j++) {
                for (int k = 0; k < i.getDimX(); k++) {
                    ps.print(i.getMatricePixel()[j][k].toString());  //écriture du pixel correspondant au coo
                    //ps.print(" ");      //Séparation de chaque pixel par un espace
                }
                ps.println();       //Retour à la ligne
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
