/**
 * Une interface de pixel qui permet de définir le comportement des classes PixelCouleur et PixelNoirBlanc
 * @author Arthur Andrianjafisolo
 * @author Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 * @version 1.0
 */
import java.io.*;

abstract interface Pixel {
    void setTeinte(int teinte);
    int getTeinte();
    RGB getCouleur();
    String toString();
}
