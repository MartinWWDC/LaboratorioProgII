
import java.util.Objects;
import java.util.Set;

public abstract class Trasmissione {
    //OVERVIEW: Classe astratta che definisc eun contratto per una trasmissione su Betazed un una o
    //          più fasce betaorarie

    //Titolo
    // public perchè è comune  a tutte le tipologie di trasmissioni e le stringhe non possono esssere modi
    // ficate. Utilizzando il modificatore final mi assicuro che neanche il riferimento all'oggeto possa cambiare
    public final String titolo;

    /*
     * RI : titolo non deve essere null e non deve essere vuota.
     */

    //EFFECTS: Costruisce una trasimssione con il titolo in input
    //         lancia NullPointerException se titolo == null o IllegalArgumentException
    //         le titolo è vuota
    public Trasmissione(final String titolo) {
        if (Objects.requireNonNull(titolo, "Non può essere null").isEmpty())
            throw new IllegalArgumentException("Titolo non può essere vuoto");
        this.titolo=titolo;
    }
    //EFFECTS: Restituisce la durata della trasmissione
    public abstract int durata();
    //EFFECTS: Restiruisce true se la fascia oraria di this si interseca con quella di t
    //         false altrimenti. Lancia NullPointerException se t == null.
    public boolean interseca(final Trasmissione t) {
        Objects.requireNonNull(t, "Trasmissione non può essere null.");
        for (FasciaBetaoraria f : fasce()) {
            for (FasciaBetaoraria q : t.fasce()) {
                if (f.interseca(q)) return true;
            }
        }
        return false;
    }
    //EFFECTS: restituisce le fasce oraria della trasmissione in un set ordinato in base 
    //         all'inzio delle occorrenze delle trasmissioni.
    public abstract Set<FasciaBetaoraria> fasce();
}