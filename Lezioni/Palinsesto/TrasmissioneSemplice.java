import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TrasmissioneSemplice extends Trasmissione {
    //OVERVIEW: Classe che estende Trasmissione e a cui corrisponde una soal fasciabetaoraria
    //fascia
    private final FasciaBetaoraria f;

    /*
     * AF : Una trasmissione semplice è : fascia betaoraria - Titolo
     * RI : f non deve essere null
     */
    //EFFECTS: Costruisce una strasmissione semplice dato il titolo
    //         e la fascia betaoraria. Lancia NullPointerException se f == null
    public TrasmissioneSemplice(final String t, final FasciaBetaoraria f) {
        super(t);
        this.f=Objects.requireNonNull(f, "f non può essere null.");
    }

    @Override
    public int durata() {
        return f.durata();
    }
    @Override
    public Set<FasciaBetaoraria> fasce() {
        Set<FasciaBetaoraria> fa = new TreeSet<>(new OrdinaFasce());
        fa.add(f);
        return fa;
    }
    @Override
    public String toString() {
        return f.inizio().toString() +" - "+titolo+"\n";
    }
    

}