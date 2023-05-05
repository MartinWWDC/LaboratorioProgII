public abstract class Piastrella implements Rivestimento {
    private int costo;
    
    /**
     * Crea una piastrella
     * @param costo
     * @throws IllegalArgumentException
     */
    public Piastrella(int costo) throws IllegalArgumentException {
        if (costo <= 0) throw new IllegalArgumentException("Il costo dev'essere positivo.");

        this.costo = costo;
    }
    
    @Override
    public int costo() {
       return costo;
    }

    

    
}
