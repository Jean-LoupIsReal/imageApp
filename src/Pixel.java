import java.io.*;
abstract interface Pixel {
    void setTeinte(int teinte);
    int getTeinte();
    RGB getCouleur();
    String toString();
}
