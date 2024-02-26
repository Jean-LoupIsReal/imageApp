import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ImageTest {
    /**
     *
     * Le test va echouer a cause de l'adresse qui ne sera jamais la meme (voir ce lien: https://dzone.com/articles/comparing-two-objects-using-assertareequal)
     *
     * @throws Exception
     */
    @Test
    public void lire() throws Exception {
        String fileNameBW = "Sherbrooke_Frontenac_nuit";
        String formatBW = "pgm";

        final File imgFileBW = new File(fileNameBW + "." + formatBW);

        final Image testBW = new ImageNoirEtBlanc();
        final Image newImgBW = new ImageNoirEtBlanc();

        testBW.lire(imgFileBW);

        newImgBW.lire(imgFileBW);

        assertEquals(testBW, newImgBW);
    }

    /**
     *
     * Le test va echouer a cause de l'adresse qui ne sera jamais la meme (voir ce lien: https://dzone.com/articles/comparing-two-objects-using-assertareequal)
     *
     * @throws Exception
     */
    @Test
    public void ecrire() throws Exception {
        String fileNameBW = "Sherbrooke_Frontenac_nuit";
        String formatBW = "pgm";

        final File imgFileBW = new File(fileNameBW + "." + formatBW);
        final File newImgFileBW = new File(fileNameBW + "." + formatBW);

        final Image testBW = new ImageNoirEtBlanc();
        final Image newImgBW = new ImageNoirEtBlanc();

        testBW.lire(imgFileBW);

        newImgBW.ecrire(newImgFileBW, testBW);

        newImgBW.lire(newImgFileBW);

        assertEquals(testBW, newImgBW);
    }

    @Test
    public void couleur_preponderanteBW() throws Exception {
        String fileNameBW = "Sherbrooke_Frontenac_nuit";
        String formatBW = "pgm";

        final File imgFileBW = new File(fileNameBW + "." + formatBW);
        final Image testBW = new ImageNoirEtBlanc();

        testBW.lire(imgFileBW);

        assertEquals( "43 43 43 ", testBW.couleur_predominante(testBW).toString());
    }

    @Test
    public void couleur_preponderanteC() throws Exception {
        String fileNameC = "Sherbrooke_Frontenac_nuit";
        String formatC = "ppm";

        final File imgFileC = new File(fileNameC + "." + formatC);
        final Image testC = new ImageCouleur();

        testC.lire(imgFileC);

        assertEquals( "40 44 53 ", testC.couleur_predominante(testC).toString());
    }
}
