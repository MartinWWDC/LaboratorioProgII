public class PiastrellaQuadrata extends Piastrella {
    // Campi
    private int lato;

    public PiastrellaQuadrata(int costo, int lato) {

        super(costo);
        if (lato <= 0) {
            throw new IllegalArgumentException("Il lato dev'essere positivo.");
        }
        this.lato = lato;
    }

    @Override
    public int superfice() {
        return lato * 4;
    }

}
