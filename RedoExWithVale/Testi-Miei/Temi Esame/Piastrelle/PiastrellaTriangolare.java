public class PiastrellaTriangolare extends Piastrella {

    // Campi
    private int base;
    private int altezza;

    public PiastrellaTriangolare(int costo, int base, int altezza) {
        super(costo);
        if (base <= 0 || altezza <= 0) {
            throw new IllegalArgumentException("Il lato dev'essere positivo.");
        }
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public int superfice() {
        return (base * altezza) / 2;
    }

}
