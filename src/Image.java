/**
 * Cette classe est la classe mère qui contient toute les methodes pour modifier une image
 * @author Arthur Andrianjafisolo
 * @author Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 * @version 1.0
 */

import java.io.*;
import java.util.*;

public class Image {

    private String nomFichier;
    private  String format;
    private Pixel matricePixel[][];
    private int dimX;
    private int dimY;

    /**
     * Cette methode est un constructeur d'image avec parametre appelee lors de la création d'un nouvel object Image
     * @param nomFichier
     * @param format
     * @param matricePixel
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

    /**
     * Constructeur d'image sans parametre
     */
    public Image(){
        this(null, null, null, 0,0);
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
     * @return la dimension en x de l'object
     */
    public void setMatricePixel(Pixel matricePixel[][]){this.matricePixel = matricePixel;};

    /**
     * @return la dimension en x de l'object
     */
    public Pixel[][] getMatricePixel(){return this.matricePixel;}

    /**
     * @return la dimension en x de l'object
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * @param dimX doit prendre une dimension en int pour la longueur en X
     */
    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    /**
     * @return la dimension en y de l'object
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * @param dimY doit prendre une dimension en int pour la hauteur en Y
     */
    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    /**
     * Cette methode lit le contenu d'un fichier PPM ou PGM pour pouvoir cree la matrice de pixel
     * @param f doit etre un fichier dans lequel l'on va chercher l'information
     */
    public void lire(File f) throws FileNotFoundException {
        //Récupère le fichier et le lit mot par mot
        Scanner scanne = new Scanner(f);
        try {
            if(scanne.hasNextLine()) {  // Lit la premiere ligne et affecte le format
                String premiereLigne = scanne.nextLine();
                setFormat(premiereLigne);
                // System.out.println("Format : " + premiereLigne); // Pour vérifier si la premiere ligne prend bien le format

                if (scanne.hasNextLine()) { //Lit la deuxième ligne et affecte X et Y
                    int dimX = scanne.nextInt();
                    int dimY = scanne.nextInt();
                    setDimY(dimY);
                    setDimX(dimX);
                    matricePixel = new Pixel[dimY][dimX];
                   // System.out.println("Dimensions : " + dimX + " x " + dimY); // Pour vérifier si la deuxieme ligne prend bien les dimensions
                }
                while (scanne.hasNext()) {  //Boucle while qui lit valeur par valeur après les 2 premieres lignes
                    String valeur = scanne.next(); // Prend la valeur 255 et ne la compte pas dans la matrice

                    if(Objects.equals(getFormat(), "P2")) { // Crée une matrice à partir d'un fichier P2(PGM)
                        affecteMatriceP2(scanne);
                    } else if(Objects.equals(getFormat(), "P3")) { // Crée une matrice à partir d'un fichier P3(PPM)
                        affecteMatriceP3(scanne);
                    }
                }
            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé ou n'a pas la bonne extension (Vous devez ouvrir un fichier PGM ou PPM) !");
        } finally {
            scanne.close();
        }
    }


    public void affecteMatriceP2(Scanner scanne){
        for (int y = 0; y < getDimY(); y++) {
            for (int x = 0; x < getDimX(); x++) {
                matricePixel[y][x] = new PixelNoirBlanc();  // Nouvelle instance pour une matrice avec des Pixels noir et blanc
                if (scanne.hasNextInt()) {                  //Si, c'est le prochain élément lu, on l'affecte dans la matrice
                    matricePixel[y][x].setTeinte(scanne.nextInt());
                }
                //System.out.print(matricePixel[y][x]); //Pour voir ce qui était affecté
            }
            //System.out.println();                    //Saut de ligne
        }
    }

    public void affecteMatriceP3(Scanner scanne){
        for (int y = 0; y < getDimY(); y++) {
            for (int x = 0; x < getDimX(); x++) {
                if (scanne.hasNextInt()) { //Si, c'est le prochain élément lu pour R, G et B, on l'affecte dans la matrice
                    int r = scanne.nextInt();
                    int g = scanne.nextInt();
                    int b = scanne.nextInt();

                    matricePixel[y][x] = new PixelCouleur(new RGB(r, g, b)); // Nouvelle instance pour une matrice avec des RGB
                }
                //System.out.print(matricePixel[y][x]); //Pour voir ce qui était affecté
            }
            //System.out.println();                    //Saut de ligne
        }
    }
    /**
     * Cette methode permet d'écrire une nouvelle image grace a la matrice
     * @param f Contient un fichier dans lequel l'on va écrire la nouvelle image
     * @param i Contient l'image que l'on desire ecrire dans le fichier f
     */
    public void ecrire(File f, Image i) throws FileNotFoundException {}

    /**
     * Cette methode prend une image et la copie dans une autre
     * @param i1 Contient l'image d'origine
     * @param i2 Contient l'on a duplique de i1
     */
    public void copier(Image i1, Image i2){
        i1.setDimX(i2.getDimX());
        i1.setDimY(i2.getDimY());
        i1.setFormat(i2.getFormat());
        i1.setNomFichier(i2.getNomFichier() + "(copie)");
        Pixel[][] matriceTemp = new Pixel[i2.getDimY()][i2.getDimX()];
        for(int y = 0; y < i2.getDimY(); ++y){
            for(int x = 0; x < i2.getDimX(); ++x){
                matriceTemp[y][x] = i2.getMatricePixel()[y][x];
            }
        }
        i1.setMatricePixel(matriceTemp);
    }
    
    /**
     * @param i Contient l'image de laquelle l'on desire extraire une partie
     * @param p1 y du point 1
     * @param c1 x du point 1
     * @param p2 y du point 2
     * @param c2 x du point 2
     * @return Le pixel qui revient le plus souvent
     */
    public Image extraire(Image i, int p1, int c1, int p2, int c2){
        if(p1 < 0 || c1 < 0 || p2 > i.getDimX() || c2 > i.getDimY())
            //Erreur
            System.out.println("out of bound, les dims sont x = " + i.getDimX() + " y = " + i.getDimY());
        //Déclare les nouvelle dimmentions de l'image
        else{
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
            Image imageTemp = new Image(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY );
            return imageTemp;
        }

        return null;
    }

    /**
     * Cette fonction reduit la taille de l'image passe en parametre par 2 puis l'enregistre en nouvelle image
     * @param i represente l'image d'origine
     */
    public Image reduire(Image i){
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
        Image nouvelleImg = new Image(i.getNomFichier(), i.getFormat(), matriceTemp, nouvDimX, nouvDimY);
        return nouvelleImg;
    }

    /**
     * Cette fonction retourne true si les deux images passe en parametre sont identiques
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
                    identique = identique && i1.getMatricePixel()[y][x].getTeinte() == i2.getMatricePixel()[y][x].getTeinte();
                    identique = identique && i1.getMatricePixel()[y][x].getCouleur().compare(i2.getMatricePixel()[y][x].getCouleur());
                }
            }
        }
        return identique;
    }

    /**
     * @return Les pixels qui reviennent le plus souvent
     */
    public RGB couleur_predominante(Image i){
            //Crée une liste pour compter le nombre de pixel different
            ArrayList<CompteurPixel> liste = new ArrayList<CompteurPixel>();
            //objet pour compter le nombre de fois qu'un pixel est dans une image
            CompteurPixel compteurPixel = new CompteurPixel(0, i.getMatricePixel()[0][0].getCouleur());
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
                        if(liste.get(t).couleur.compare(i.getMatricePixel()[y][x].getCouleur())){
                            liste.get(t).nb++;
                            est_dans_liste = true;
                        }
                    }
                    if(!(est_dans_liste)){
                        compteurPixel = new CompteurPixel(0, i.getMatricePixel()[y][x].getCouleur());
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
                matriceTemp[x][y] = i.getMatricePixel()[y][x];
            }
        }
        i.setMatricePixel(matriceTemp);
        int dimTemp = i.getDimY();
        i.setDimY(getDimX());
        i.setDimX(dimTemp);
    }

    /**
     * Cette fonction éclaircit ou noircit l'image au complet
     * @param pourcentage est la valeur selon laquelle on veut éclaircir ou noircir l'image, 100 est la valeur initiale
     */
    public void eclaircirNoircir(int pourcentage){
        for(int x = 0; x < getDimX(); x++)
        {
            for(int y = 0; y < getDimY(); y++)
            {
                matricePixel[y][x].setTeinte(matricePixel[y][x].getTeinte() * pourcentage/100);
            }
        }
    }
}
