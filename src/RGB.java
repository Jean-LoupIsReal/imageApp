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
        return R;
    }

    public int getG() {
        return G;
    }

    public int getB() {
        return B;
    }

    public void setR(int r) {
        if(r < 0 || r > 255)
            // a ajouter Exception
            System.out.print("R de rgb a recu une valeur invalide");
        R = r;
    }
    public void setG(int g) {
        if(g < 0 || g > 255)
            // a ajouter Exception
            System.out.print("G de rgb a recu une valeur invalide");
        G = g;
    }

    public void setB(int b) {
        if(b < 0 || b > 255)
            // a ajouter Exception
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


}
