
/**
 * Questa classe permette di rappresentare delle valute.
 */
public enum Valuta {
    DOLLARO("$"),
    EURO("€"),
    FRANCO("₣"),
    LIRA("₺"),
    RUPIA("₹"),
    STERLINA("£"),
    YEN("¥");
    /**
     * IR:simbolo not blank
     * AF: simbolo rappresenta il simbolo di a cui una valuta è associata 
     */
    private final String simbolo;

    /**
     * Costruttore dell'enum Valuta. lancia un eccezione se il valore non è supportato
     *
     * @param simbolo il simbolo di valuta associato alla costante.
     * @throws IllegalAccessError
     */
    Valuta(String simbolo) {
        if(simbolo.trim().isEmpty()){
            throw new IllegalAccessError("valore non valido");
        }
        this.simbolo = simbolo;
    }

    /**
     * Restituisce il simbolo di valuta associato alla costante.
     *
     * @return il simbolo di valuta.
     */
    public String getSimbolo() {
        return simbolo;
    }

    

    
    
}
