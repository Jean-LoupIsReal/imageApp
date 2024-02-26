import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PixelNoirBlanc[][] matrice = null;

        String fileName = "Sherbrooke_Frontenac_nuit";
        String format = "pgm";
        Image test = new Image(null, null, matrice, 0, 0);
        File imgFile = new File(fileName + "." + format);

        test.lire(imgFile);
    }
}