import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Palinsesto {
    //OVERVIEW: Classe che implementa un palinsesto su betazed, un elenco immutabile di 
    //          trasmissioni e le relative fasce orarie

    //Elenco di trasmissioni
    private final List<Trasmissione> ts;

    /*
     * AF = rappresentazione come un elenco ordinato in base all'inzio delle trasmisioni
     * RI = ts non deve essere null e non deve contenre trasmissione che si sovrappongono.
     */
    //EFFECTS: Costruisce un palinsesto con la lista di trasmissioni data.
    //         Lancia NullPointerException se ts == null
    //         IllegalArgumentException se ts contiene trasmissioni che si sovrappongono
    public Palinsesto(final List<Trasmissione> ts) {
        Objects.requireNonNull(ts, "Non può essere null.");
        for (int i=0; i<ts.size(); i++) {
            for (int j=i+1; j<ts.size(); j++) {
                if(ts.get(i).interseca(ts.get(j)))
                   throw new IllegalArgumentException("Le trasmissioni non possono intersecarsi");

            }
        }
        this.ts = ts;
    }

    @Override
    public String toString() {
        Set<FasciaBetaoraria> fasce = new TreeSet<>(new OrdinaFasce());
        Map<FasciaBetaoraria, String> titoli = new HashMap<>();
        for (Trasmissione t : ts) {
            for (FasciaBetaoraria f : t.fasce()) {
                fasce.add(f);
                titoli.put(f, t.titolo);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (FasciaBetaoraria f : fasce) {
            sb.append(f.inizio().toString()+ " - "+titoli.get(f)+"\n");
        }
        return sb.toString();
    }

}