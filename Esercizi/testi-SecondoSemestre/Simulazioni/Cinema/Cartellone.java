import java.util.ArrayList;
import java.util.List;

/**
 * Cartellone permette di rappresentare il calenndario di programmazioni di un cinema
 */
public class Cartellone {

    /**
     * Overview: 
     * Permette di rappresentare una proiezione con il suo titolo e la sua programmazione
     */
    public class Proiezione{
        /**
         * IR:
         * titolo non null e non blank
         * programmazion  non null;
         */
        private final String titolo;
        private Programmazione programma;

        public Proiezione(String titolo, Programmazione programma) {
            if(titolo.isBlank()){
                throw new IllegalArgumentException("Titolo non può essere blank");
            }
            this.titolo = titolo;
            this.programma = programma;
        }

        @Override
        public String toString() {
            return titolo + ": "+programma.getGiorni();
        }

        
        
        
    }
    /**
     * IR:
     * nome non può essere blank
     * lista  non può contenere giorni  con sovrapposizioni 
     * durata  28<=durata<=31
     * AF:
     * nome rappresenta il nome del cartellone
     * lista rappresenta un elenco dei film con rispettiva programmazion
     * durata rappresenta la durata di un cartellone
     */
    private final String nome;
    private final List<Proiezione> lista;
    private int durata;
    /**
     * Costruttore
     * @param nome non può essere blank
     * @param durata 28<=durata<=31
     */
    public Cartellone(String nome, int durata) {
        if(nome.isBlank()){
            throw new IllegalArgumentException("nome non può essere");
        }
        this.nome = nome;

        lista=new ArrayList<Proiezione>();
        if(durata<28 || durata >31){
            throw new IllegalArgumentException("durata non rispetta i parametri");
   
        }
        this.durata = durata;
    }
    /**
     * 
     * @param Titolo
     * @param programmazione
     * @throws IllegalArgumentException
     */
    public void addFilm(String Titolo,Programmazione programmazione)throws IllegalArgumentException{

    }


}
