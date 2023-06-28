import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Overvirew: permette la rappresentazione di un cambiavalute dotato di cassa e tassi di cambio per le valute contenute in essa
 */
public class CambiaValute {

    /**
     * Tasso di cambio permette di associare un determinato importo positivo ad un altro importo positivo
     */
    public record TassoDiCambio(Importo a,Importo b) {
        /**
         * IR: 
         * a e b devono essere maggiori di zero e avere due valute diverse
         */
        /**
         * Crea un tasso di cambio che lancia illegalArgument se  a e b hanno la stessa valuta o sono negativi
         * @param a
         * @param b
         * @throws IllegalArgumentException
         */
        public TassoDiCambio{
            Objects.requireNonNull(a,"importo nullo");
            Objects.requireNonNull(b,"importo nullo");

            if(a.getValuta()==b.getValuta() ||!a.isPositive() || !b.isPositive()){
                throw new IllegalArgumentException("valori non valid");
            }
            

        }
        @Override
        public String toString() {
            String str="";
            str+=a.toString()+"|"+b.toString();
            return str;
        }
    }
    /**
     * IR:
     * cassa 
     * AF:
     * la cassa rappresenta la lista delle monete contenute nel cambia volute con il corrispettivo importo  
     * tassi rappresenta una lista di tassi di cambio per il quale è possibile scambiare le valute
     */
    private Cassa cassa;
    private Map<Valuta,TassoDiCambio[]> tassi;
    /**
     * crea un cambia valute 
     * @param a definsce il saldo che dovrà avere
     */
    public CambiaValute(Importo[] a) {
        cassa=new Cassa();
        tassi=new HashMap<Valuta,TassoDiCambio[]>();
        for (Valuta val : Valuta.values()) { 
            tassi.put(val,null);
        }
        for(Importo imp:a){
            aggiungiCassa(imp);
        }    
    }
    
    /**
     * Dati due importi permette di creare un nuovo tasso di cambio per una determinata Valuta          * a e b devono essere maggiori di zero e avere due valute diverse
     * @param a
     * @param b
     * @throws IllegalArgumentException
     */
    public void cambiaTasso(Importo a,Importo b) {
     //TODO
     throw new RuntimeException("metodo non implementat");
    }

    /**
     * Aggiunge un importo a alla cassa
     * @param a
     * @throws NullPointerException se a è null
     */
    private void aggiungiCassa(Importo a){
        Objects.requireNonNull(a,"importo nullo");
        cassa.versamento(a);
    }
    /**
     * Rimuove un importo a alla cassa
     * @param a
     * @throws NullPointerException se a è null
     */
    private void rimuoviCassa(Importo a){
        Objects.requireNonNull(a,"importo nullo");
        cassa.prelievo(a);
    }
    /**
     * se ha memorizzato il tasso di cambio tra la valuta di a e la valuta vale ha in cassa l'equivalente dell'importo nella nuova valuta procede a: 
     * versare in cassa l'importo nella valuta originaria 
     * prelevare l'importo equivalente nella nuova valuta; viceversa segnala opportunamente gli errori relativi alla mancanza di conoscenza del tasso, o di disponibilità dei fondi. 
     * @param a
     * @param val
     * @return 
     * @throws NullPointerException
     */
    public Importo opera(Importo a,Valuta val)throws NullPointerException{
        Objects.requireNonNull(a);
        Objects.requireNonNull(val);
        //if(tassi.get(val))
        //TODO
        throw new RuntimeException("metodo non implementat");
    }
}
