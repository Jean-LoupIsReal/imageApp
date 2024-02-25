public class RGB {
    private int R;
    private int G;
    private int B;
    public RGB(int r, int g, int b){
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }

    public int getR() {

        if(R > 255)
            return 255;
        return R;
    }

    public int getG() {

        if(G > 255)
            return 255;
    return G;
    }

    public int getB() {
        if(B > 255)
            return 255;
        return B;
    }
    /**
     * Cette méthode attribut une valeur a la calsse
     * @param r est la couleur en rouge
     */
    public void setR(int r) {
        if (r < 0)
            //ajouter Exception
            System.out.print("G de rgb a recu une valeur invalide");
        R = r;
    }
    /**
     * Cette méthode attribut une valeur a la calsse
     * @param g est la couleur en vert
     */
    public void setG(int g) {
        if (g < 0)
            // ajouter Exception
            System.out.print("G de rgb a recu une valeur invalide");
        G = g;
    }
    /**
     * Cette méthode attribut une valeur a la calsse
     * @param b est la couleur en bleu
     */
    public void setB(int b) {
        if (b < 0)
            // ajouter Exception
            System.out.print("B de rgb a recu une valeur invalide");
        B = b;
    }
    public boolean compare(RGB rgb){
        boolean identique = true;
        identique = identique && this.getR() == rgb.getR();
        identique = identique && this.getG() == rgb.getG();
        identique = identique && this.getB() == rgb.getB();
        return identique;
    }

    /**public void ecrire(out)
    {
        out(this.R + " " + this.G + " " + this.B + " ")
    }*/


}
