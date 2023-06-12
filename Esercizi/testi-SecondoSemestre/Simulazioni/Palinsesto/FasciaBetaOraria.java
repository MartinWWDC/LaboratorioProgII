import java.util.Objects;

/**
 * Overview: la fascia beta oraria è una classe che permette di rappresentare una fascia oraria sul pianeta Betazed
 */
public class FasciaBetaOraria{
    private final BetaOrario inizio;
    private final int durata;
   

    /**
     *IR:
     * BetaMinuti è compreso tra 0 e 79 compresi 
     * AF:
     * inizio  rappresenta l'ora di inizio del programma
     * durata rappresenta il numerop di betaminuti di durata
     */
    
    public FasciaBetaOraria(BetaOrario inizio, int durata) {
        this.inizio = inizio;
        if(durata>79 || durata < 0){
            throw new IllegalArgumentException("BetaMinuti non rispecchia le condizioni");
        }
        inizio.addDurata(durata);
        this.durata = durata;
    }
    /**
     * restiuiesce l'ora di inizio della fascia  d'orario  
     * @return
     */
    public BetaOrario getInizio(){
        return inizio;
    }
    /**
     * Restiuiscre l'orario in cui si concluse la fascia oraria 
     * @return
     */
    public BetaOrario getOrarioFine(){
        return inizio.addDurata(durata);
    }
    /**
     * estituisce true se f si interseca con this(lo fa se
     * ha almeno un betaminuto in comune) false altrimenti. 
     * @throws NullPointerException se f == null
     * @param f
     * @return
     */
    public boolean interseca(final FasciaBetaOraria f) {
            Objects.requireNonNull(f, "Non può essere null.");
            if (inizio.confronta(f.inizio)) {
                if (getOrarioFine().confronta(f.inizio)) {
                    return false;
                }
                return true;
            }
            if (f.getOrarioFine().confronta(inizio)) {
                return false;
            }
            return true;
        }

    public int durata() {
        return durata;
    }

}