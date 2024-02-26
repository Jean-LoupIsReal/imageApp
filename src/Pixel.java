/**
 * Une interface de pixel qui permet de définir le comportement des classes PixelCouleur et PixelNoirBlanc
 * @auteur Arthur Andrianjafisolo
 * @autor Audy Altis
 * @author Jean-Loup Dandurand-Pominville
 */
import java.io.*;

abstract interface Pixel {
    void setTeinte(int teinte);
    int getTeinte();
    RGB getCouleur();
    String toString();
}
