import java.util.Set;
import java.util.TreeSet;

public class TrasmissioneSemplice extends Trasmissione {

    private final FasciaBetaOraria orari;


    public TrasmissioneSemplice(String titolo,FasciaBetaOraria orari) {
        super(titolo);
        this.orari=orari;
        
    }


    @Override
    public int durata() {
        return orari.durata();
    }
    @Override
    public Set<FasciaBetaOraria> fasce() {
        Set<FasciaBetaOraria> fa = new TreeSet<>();
        fa.add(orari);
        return fa;
    }
    @Override
    public String toString() {
        return orari.getInizio().toString() +" - "+titolo+"\n";
    }
    

}
