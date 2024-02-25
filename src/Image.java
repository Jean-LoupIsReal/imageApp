/**
 * Cette méthode est appelée lors de la création d'un nouvel object Image
 * @auteur Arthur Andrianjafisolo
 * @autor Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 */
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class Image {

    private String nomFichier;
    private  String format;
    private Pixel matricePixel[][];
    private int dimX;
    private int dimY;

    /**
     * Cette méthode est appelée lors de la création d'un nouvel object Image
     *
     * @param nomFichier
     * @param format
     * @param dimX
     * @param dimY
     */
    public Image(String nomFichier, String format, Pixel matricePixel[][], int dimX, int dimY) {
        this.nomFichier = nomFichier;
        this.format = format;
        this.dimX = dimX;
        this.dimY = dimY;
        this.matricePixel = matricePixel;
    }

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
     * @param nomFichier doit etre une string
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
    /**
     * @return la dimention en x de l'object
     */
    public void setMatricePixel(Pixel matricePixel[][]){this.matricePixel = matricePixel;};
    /**
     * @return la dimention en x de l'object
     */
    public Pixel[][] getMatrixPixel(){return this.matricePixel;}
    /**
     * @return la dimention en x de l'object
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * @param dimX doit prendre une dimention en int pour la longueur en x
     */
    public void setDimX(int dimX) {
        this.dimX = dimX;
    }
    /**
     * @return la dimention en y de l'object
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * @param dimY doit prendre une dimention en int pour la hauteur en y
     */
    public void setDimY(int dimY) {
        this.dimY = dimY;
    }
    /**
     * @param f doit etre un fichier dans lequel l'on va chercher l'information
     * Permet de lire l'information d'un fichier
     */
    public void lire(File f) throws IOException {
        //Récupère le fichier et le lit ligne par ligne
        BufferedReader lecture = new BufferedReader(new FileReader(f));
        String ligne = null;
        int nbrLignes = 1;

        try {
            while((ligne = lecture.readLine()) != null){  //Boucle while qui lit toutes les ligne
                String[] dimension = ligne.split(" ");
                if(nbrLignes == 1){                      //Prends les informations de la première ligne et l'affecte au format
                    setFormat(ligne);
                } else if (nbrLignes == 2) {            //Prend les dimensions des 2ème ligne et l'affecte à dimY et DimX
                    setDimY(Integer.parseInt(dimension[0]));
                    setDimX(Integer.parseInt(dimension[1]));
                }
                nbrLignes++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            lecture.close();
        }
    }

    /**
     * @param i doit etre une image que l'on desire écrire dans un fichier
     * @param f doit etre un fichier dans lequel l'on va écrire l'information
     */

    public void ecrire(File f, Image i) throws FileNotFoundException {}
    /**
     * @param i1 doit etre une image que l'on desire changer
     * @param i2 doit etre une image que l'on désire dupliquer
     */
    public void copier(Image i1, Image i2){
        i1.setDimX(i2.getDimX());
        i1.setDimY(i2.getDimY());
        i1.setFormat(i2.getFormat());
        i1.setNomFichier(i2.getNomFichier());
        i1.setMatricePixel(i2.getMatrixPixel());
    }
    
    /**
     * @param i Contien l'image de laquel l'on désire extraire une partie
     * @param p1 y du point 1
     * @param c1 x du point 1
     * @param p2 y du point 2
     * @param c2 x du point 2
     * @return le pixiel qui revient le plus souvent
     */
    public Image extraire(Image i, int p1, int c1, int p2, int c2){
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
                matriceTemp[y][x] = i.getMatrixPixel()[p1 + y][c1 + x];
            }
        }
        //Entre les nouvelles informations dans un nouvel objet
        Image imageTemp = new Image(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY );
        return imageTemp;
    }

    /**
     *
     * Cette fonction réduit la taille de l'image passé en paramettre par 2 puis l'enregistre en nouvelle image
     *
     * @param i représente l'image d'origine
     */
    public Image reduire(Image i){
        int nouvDimX = i.getDimX()/2;
        int nouvDimY = i.getDimY()/2;
        Pixel[][] matriceTemp = new Pixel[nouvDimY][nouvDimX];
        for(int x = 0; x < nouvDimX; x++)
        {
            for(int y = 0; y < nouvDimY; y++)
            {
                matriceTemp[y][x] = i.getMatrixPixel()[y][x];
            }
        }
        Image nouvelleImg = new Image(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY);
        return nouvelleImg;
    }
    /**
     *
     * Cette fonction retourne true si les deux images passé en paramettre sont identiques
     *
     * @param i1 représente l'image 1
     * @param i2 représente l'image 2
     */
    public boolean sont_identiques(Image i1, Image i2){
        boolean identique = true;
        // regarde si les images ont la meme grandeur
        identique = identique && i1.getDimX() == i2.getDimX();
        identique = identique && i1.getDimY() == i2.getDimY();
        if(identique)
        {
            for(int x = 0; x < i1.getDimX(); x++)
            {
                for(int y = 0; y < i1.getDimY(); y++)
                {
                    identique = identique && i1.getMatrixPixel()[y][x].getTeinte() == i2.getMatrixPixel()[y][x].getTeinte();
                    identique = identique && i1.getMatrixPixel()[y][x].getCouleur().compare(i2.getMatrixPixel()[y][x].getCouleur());
                }
            }
        }
        return identique;
    }
    /**
     * @return le pixiel qui revient le plus souvent
     */
public RGB couleur_predominante(Image i){
        //Crée une liste pour compter le nombre de pixel different
        ArrayList<CompteurPixel> liste = new ArrayList<CompteurPixel>();
        //objet pour compter le nombre de fois qu'un pixel est dans une image
        CompteurPixel compteurPixel = new CompteurPixel(0, i.getMatrixPixel()[0][0].getCouleur());
        //Ajoute le premier objet pour entrer dans la boucle prenant a compte la size de la liste
        liste.add(compteurPixel);
        // regarde si la couleur est dans la liste
        boolean est_dans_liste;

        //Boucle pour regarder dans l'antieretee de la matrix de pixel
        for(int y = 0; y < i.getDimY(); y++)
        {
            for(int x = 0; x < i.getDimY(); x++)
            {
                est_dans_liste = false;
                //entre dans la liste
                for(int t = 0; t < liste.size(); t++){
                    //
                    if(liste.get(t).couleur.compare(i.getMatrixPixel()[y][x].getCouleur())){
                        liste.get(t).nb++;
                        est_dans_liste = true;
                    }
                }
                if(!(est_dans_liste)){
                    compteurPixel = new CompteurPixel(0, i.getMatrixPixel()[y][x].getCouleur());
                    liste.add(compteurPixel);
                }
            }
        }
        //iterator de la liste
        int itPredominant = 0;
        //Boucle qui verifie dans la liste quel est la couleur predominante
        for(int it = 0; it < liste.size(); it++){
            if(liste.get(itPredominant).nb < liste.get(it).nb){
                itPredominant = it;
            }
        }
        return liste.get(itPredominant).couleur;
    }
    /**
     *
     * Cette fonction fait une rotation de 90 degrés sur l'image reçus en paramettre puis l'enregistre en nouvelle image
     *
     * @param i représente l'image d'origine
     */
    public void pivoter90(Image i){
        Pixel[][] matriceTemp = new Pixel[i.getDimX()][i.getDimY()];
        for(int x = 0; x < i.getDimX(); x++)
        {
            for(int y = 0; y < i.getDimY(); y++)
            {
                matriceTemp[x][y] = i.getMatrixPixel()[y][x];
            }
        }
        i.setMatricePixel(matriceTemp);
    }
    /**
     *
     * Cette fonction éclairci/noirci l'image au complet
     *
     * @param pourcentage est la valeur selon laquel on veut éclaircir/noircir l'image, 100 = valeur initiale
     */
    public void eclaircirNoircir(int pourcentage){
        for(int x = 0; x < i.getDimX(); x++)
        {
            for(int y = 0; y < i.getDimY(); y++)
            {
                matriceTemp[y][x].setTeinte(matriceTemp[y][x].getTeinte() * pourcentage/100);
            }
        }
    }

}

