
public abstract class Piastrella implements Rivestimento {
    // Campi
    private int costo;

    public int costo() {
        return costo;
    }

    public Piastrella(int costo) {
        if (costo < 0) {
            throw new IllegalArgumentException("costo non può essere negativo");
        }

        this.costo = costo;
    }

}
