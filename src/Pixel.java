public class Pixel {
    private int value;

    /**
     *Cette méthode est appelée lors de la création d'un nouvel object Image
     *
     * @param value
     */
    public Pixel(int value) {
        this.value = value;
    }

    /**
     * @return value du Pixel
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
}
