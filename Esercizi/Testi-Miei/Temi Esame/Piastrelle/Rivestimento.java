
/**
 * Interfaccia che descrive un <em>rivestimento</em>, cioè una qualunque entità
 * dotata di
 * <em>costo</em> e <em>superficie</em>.
 */
public interface Rivestimento {
    /**
     * Restituisce il costo del rivestimento
     * 
     * @return
     */
    int costo();

    /**
     * Restituisce la superficie del rivestimento.
     *
     * @return la superficie, ha sempre valore positivo.
     */
    int superfice();
}
