public class PiastrellaRombo extends Piastrella {
    // Campi
    private int diagonaleMinore;
    private int diagonaleMaggiore;

    public PiastrellaRombo(int costo, int diagonaleMinore, int diagonaleMaggiore) {

        super(costo);
        if (diagonaleMinore <= 0 || diagonaleMaggiore <= 0) {
            throw new IllegalArgumentException("Il lato dev'essere positivo.");
        }
        this.diagonaleMinore = diagonaleMinore;
        this.diagonaleMaggiore = diagonaleMaggiore;
    }

    @Override
    public int superfice() {
        return diagonaleMaggiore * diagonaleMinore;
    }

}
