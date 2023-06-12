import java.util.Objects;

public class FasciaBetaoraria {
    //OVERVIEW: Classe immutabile che erappresenta una fascia betaoraria dtata da un betaorario di inizio
    //          e la sua durata.

    //Inizio
    private final Betaorario inizio;
    //Durata
    private final int durata;

    /*
     * AF : Una fascia betaoraria è tipicament : betaorario durata
     * RI : inzio non deve essere null, durata deve essere tale che somata a betaorario
     *      dia un orario di fine nella stessa giornata e non può esser enegativa
     */

    //EFFECTS: Costruisce una fascia betaoraria con il betaorario e la durata 
    //         in input. Lancia NullPointerException se inizio == null
    //         IllegalArgumentExcetion se durata porta la fasca in un orario di fine che superaq la giornata o
    //         è non positiva
    public FasciaBetaoraria (final Betaorario inizio, final int durata) {
        Objects.requireNonNull(inizio, "Non può essere null.");
        if(durata<=0 || durata+inizio.betaminuti() > 2480) throw new IllegalArgumentException("Durata non valida.");
        this.inizio = inizio;
        this.durata = durata;
    }
    //EFFECTS: Restituisce true se f si interseca con this(lo fa se
    //          ha almeno un betaminuto in comune) false altrimenti. 
    //          LAncia NullPointerException sw f == null
    public boolean interseca(final FasciaBetaoraria f) {
        Objects.requireNonNull(f, "Non può essere null.");
        if (inizio.confronta(f.inizio)) {
            if (fine().confronta(f.inizio)) {
                return false;
            }
            return true;
        }
        if (f.fine().confronta(inizio)) {
            return false;
        }
        return true;
    }
    //EFFECTS: Restituisce il betaorario alla fine della durata.
    public Betaorario fine() {
        return inizio.somma(durata);
    }
    //EFFECTS: Restituisce l'inizio della fasca oraria
    public Betaorario inizio() {
        return inizio;
    }
    //EFFECTS: Restituisce la durata della fasca oraria
    public int durata() {
        return durata;
    }

    @Override
    public String toString(){
        return inizio.toString() + " "+durata;
    }

}