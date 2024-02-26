import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "Sherbrooke_Frontenac_nuit";
        String format = "ppm";
        Image test = new Image();
        File imgFile = new File(fileName + "." + format);

        test.lire(imgFile);


    }
}