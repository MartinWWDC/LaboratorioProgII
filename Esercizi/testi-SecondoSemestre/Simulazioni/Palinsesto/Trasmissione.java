import java.util.Objects;
import java.util.Set;

/**
 * OVERVIEW: Classe astratta che definisc eun contratto per una trasmissione su Betazed un una o        più fasce betaorarie
*/
public abstract class Trasmissione {
    /**
     * IR:
     * titolo non deve essere null ne blanc
     * AF:
     * titolo rappresenta il titolo della trasmissione
     */
    public final String titolo;

    
    public Trasmissione(String titolo) {
        if(titolo.isBlank()){
            throw new NullPointerException("titolo non va bene");
        }
        this.titolo=titolo;


    }
    /**
     * Resituisce la durata della trasmissione
     * @return
     */
    public abstract int durata();

    /**
     * Restiruisce true se la fascia oraria di this si interseca con quella di t
     * false altrimenti. Lancia NullPointerException se t == null.
     * @param t
     * @return
     */
    public boolean interseca(final Trasmissione t) {
        Objects.requireNonNull(t, "Trasmissione non può essere null.");
        for (FasciaBetaOraria f : fasce()) {
            for (FasciaBetaOraria q : t.fasce()) {
                if (f.interseca(q)) return true;
            }
        }
        return false;
    }
    /**
     * restituisce le fasce oraria della trasmissione in un set ordinato in base 
     * all'inzio delle occorrenze delle trasmissioni.
     * @return
     */
    public abstract Set<FasciaBetaOraria> fasce(); 
    

}
