import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "Sherbrooke_Frontenac_nuit";
        String format = "ppm";
        Image test = new Image();
        File imgFile = new File(fileName + "." + format);
        test.lire(imgFile);
        Image copieTest = new Image();
        test.copier(copieTest, test);
        if(test.sont_identiques(copieTest, test))
            System.out.println("sont ="); //Pour voir ce qui était affecté
        else
            System.out.println("sont !=");

        System.out.println(test.couleur_predominante(test));



    }
}