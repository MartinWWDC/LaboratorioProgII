import java.util.Set;
import java.util.TreeSet;

public class Radiogiornale extends Trasmissione {
    //OVERVIEW: Classe immutabile che rappresenta una tipo particolare di trasmissione
    //          Viene trasmesso infatti sempre alle ore 09:40, 11:40, 19:40, 21:40, 22:40 e 25:40.
    //          e ha una durata inferiore a 79 beta minuti

    //Durata
    private final int d;
    
    /*
     * AF = Una trasmissione radiogiornale è betaorario - titolo per tutte le occorrenze
     * RI = d < 79 , d > 0
     */
    //EFFECTS: Costruisce una trasmissione radiogiornale con la duratta e il titolo dati
    //         Lanci aIllegalArgumentException se d <= 0 o d>= 79
    public Radiogiornale(final String t, final int d) {
        super(t);
        if(d<=0||d>=79) throw new IllegalArgumentException("Durata non valida");
        this.d=d;
    }

    @Override
    public int durata() {
        return d;
    }

    @Override
    public Set<FasciaBetaoraria> fasce() {
        Set<FasciaBetaoraria> fasce = new TreeSet<>(new OrdinaFasce());
        fasce.add(new FasciaBetaoraria(new Betaorario(9, 40), d));
        fasce.add(new FasciaBetaoraria(new Betaorario(11, 40), d));
        fasce.add(new FasciaBetaoraria(new Betaorario(19, 40), d));
        fasce.add(new FasciaBetaoraria(new Betaorario(21, 40), d));
        fasce.add(new FasciaBetaoraria(new Betaorario(22, 40), d));
        fasce.add(new FasciaBetaoraria(new Betaorario(25, 40), d));
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