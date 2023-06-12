
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TrasmissionePeriodica extends Trasmissione {
    //OVERVIEW: Classe immutabile che estende Trasmissione e definisce una
    //          trasmissione periodica che si ripete a distanza data e la cui durata 
    //          è sempre uguale

    //Fascia iniziale contenente anche la durata
    private final FasciaBetaoraria f;
    //Numeor di volte che si ripete
    private final int n;
    //Distanza in betaminuti da un inzion all'altro 
    private final int d;

    /*
     * AF = elenco di ( fascia beta oraria - titolo ) in ordine di inizio
     * RI = f non deve essere null, n e d devono essere compatibili con la durata di f(
     *       
     * quindi d non può far sforare nel giorno successivo e deve essere tale che l'inizio della successiva 
     * sia dopo la fine della precedente e n non deve essere tale da sforare nel giorno successivo: esempio, se
     * la prima occorrenza della trasmissione è alle 13:30 e dura 40 betaminuti e d è 1120 betaminuti, n non potrà essere > 2
     * in quanto significherebbe sforare nel giorno successivo)
     * 
     */
    //EFFECTS: Costruisce una trasmissione periodica con data fascia iniziale data(la cui durata è uguale per turre le fasce) 
    //         il numero di volte che la trasmissione si ripete e a quale distanza si ripete
    //         lancia NullPointerException se f == null
    //         IllegalArgumentException se:
    //             n o d < 0
    //             f.inizio().betaminuti() + f.durata() > f.inizio().betaminuti()+d 
    //             f.inizio().betaminuti()+d > 2480
    //             n * d + f.inizio().betaminuti() > 2480
    public TrasmissionePeriodica(final String t, final FasciaBetaoraria f, final int n, final int d) {
        super(t);
        Objects.requireNonNull(f, "f non può essere null.");
        if(n<0||d<0||f.inizio().betaminuti() + f.durata() > f.inizio().betaminuti()+d||
        f.inizio().betaminuti()+d > 2480||(n-1) * d + f.inizio().betaminuti() > 2480) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        this.f = f;
        this.n = n;
        this.d=d;
    }
    //EFFECTS: Restituisce la durata della singola trasmissione
    @Override
    public int durata() {
        return f.durata();
    }
    //EFFECTS: Ritorna l'elenco delle fasce betaorarie in cui la trasmissione si svolgerà
    @Override
    public Set<FasciaBetaoraria> fasce() {
        Set<FasciaBetaoraria> fasce = new TreeSet<>(new OrdinaFasce());
        fasce.add(f);
        for (int i = 0; i<n; i++) {
            Betaorario nuovo = f.inizio().somma(d);
            FasciaBetaoraria nuova = new FasciaBetaoraria(nuovo, f.durata());
            fasce.add(nuova);
        }
        return fasce;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (FasciaBetaoraria f : fasce()) {
            sb.append(f.inizio().toString()+" - "+titolo+"\n");
        }
        return sb.toString();
    }

}