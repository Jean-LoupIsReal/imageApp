/**
 * Cette classe est la classe fille d'Image
 * @auteur Arthur Andrianjafisolo
 * @autor Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 */

import java.io.*;

public class ImageCouleur extends Image{

    /**
     * Cette methode est un constructeur avec parametre qui prend les valeurs de classe Image et qui est appelee lors de la création d'un nouvel object ImageCouleur
     * @param nomFichier
     * @param format
     * @param matricePixel
     * @param dimX
     * @param dimY
     */
    public ImageCouleur(String nomFichier, String format, Pixel matricePixel[][], int dimX, int dimY) {
        super(nomFichier, format, matricePixel, dimX, dimY);;
    }

    /**
     * Constructeur sans parametre
     */
    public ImageCouleur() {
        this(null,null, null,0,0);
    }
    /**
     * @param i Contient l'image de laquelle l'on desire extraire une partie
     * @param p1 y du point 1
     * @param c1 x du point 1
     * @param p2 y du point 2
     * @param c2 x du point 2
     * @return Le pixel qui revient le plus souvent
     */
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
    /**
     * Cette fonction reduit la taille de l'image passe en parametre par 2 puis l'enregistre en nouvelle image
     * @param i represente l'image d'origine
     */
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

    /**
     * Methode ecrire qui permet de cree une image de couleur
     * @param f Contient un fichier dans lequel l'on va écrire la nouvelle image
     * @param i Contient l'image que l'on desire ecrire dans le fichier f
     * @throws FileNotFoundException dans le cas d'une erreur d'ecrire dans un fichier
     */
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
