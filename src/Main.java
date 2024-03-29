import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //=================Test Jean Loup ===================
        String fileName = "Sherbrooke_Frontenac_nuit";
        String format = "ppm";
        Image test = new Image();
        File imgFile = new File(fileName + "." + format);
        test.lire(imgFile);
        Image copieTest = new Image();
        /*test.copier(copieTest, test);
        if(test.sont_identiques(copieTest, test))
            System.out.println("sont ="); //Pour voir ce qui était affecté
        else
            System.out.println("sont !=");
        System.out.println(test.couleur_predominante(test));*/
        //==================Test noir et blanc====================================
        fileName = "Sherbrooke_Frontenac_nuit";
        String formatBW = "pgm";
        test = new Image();
        File imgFileBW = new File(fileName + "." + formatBW);

        File newImgFileBW = new File(fileName + "BW." + formatBW);

        ImageNoirEtBlanc newImgBW = new ImageNoirEtBlanc();

        test.lire(imgFileBW);        //Fonctionne

        newImgBW.ecrire(newImgFileBW, test);        //Fonctionne

        System.out.println("La couleur principale de l'image en noir et blanc est: " + test.couleur_predominante(test).toString());        //Fonctionne

        //==================Test couleur====================================
        String formatC = "ppm";
        Image test2 = new Image();
        File imgFileC = new File(fileName + "." + formatC);

        File newImgFileC = new File(fileName + "C." + formatC);

        ImageCouleur newImgC = new ImageCouleur();

        test2.lire(imgFileC);        //Fonctionne

        newImgC.ecrire(newImgFileC, test2);        //Fonctionne

        System.out.println("La couleur principale de l'image couleur  est: " + test2.couleur_predominante(test2).toString());

        //==================================== Test extraire/reduire ===================================

        newImgBW.lire(newImgFileBW);
        ImageNoirEtBlanc testExtraire = newImgBW.extraire(newImgBW,0 , 119, 192, 255);        //Fonctionne
        File fileTestExtraire = new File("testExtraire.pgm");
        testExtraire.ecrire(fileTestExtraire, testExtraire);//Fonctionne

        System.out.println("La couleur principale de l'image en noir et blanc est: " + test.couleur_predominante(test).toString());
        // Fonctionne
        ImageNoirEtBlanc testReduire;
        testReduire = newImgBW.reduire(newImgBW);
        File fileTestReduire = new File("testReduire.pgm");
        testReduire.ecrire(fileTestReduire, testReduire);//Fonctionne


        newImgBW.eclaircirNoircir(50);
        File fileTestEclaircirNoircir = new File("testEclaircirNoircir.pgm");
        newImgBW.ecrire(fileTestEclaircirNoircir, newImgBW);//Fonctionne

        newImgBW.pivoter90(newImgBW);
        File fileTestPivot = new File("testPivot.pgm");
        newImgBW.ecrire(fileTestPivot, newImgBW);//Fonctionne
    }
}