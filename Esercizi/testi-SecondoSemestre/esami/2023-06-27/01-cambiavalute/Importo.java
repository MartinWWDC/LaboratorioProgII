import java.math.BigDecimal;
import java.util.Objects;

/**
 * Overview:
 * importo permette di rappresenta l'importo di una transazione
 * rappresentandone il valore e la valuta
 */
public class Importo implements Comparable<Importo>{
    private BigDecimal valore;
    private Valuta valuta;
    /**
     * IR:
     * valore deve avere al massimo due cifre significative dopo la virgola e non deve essere null
     * valuta non deve essere null
     * AF:
     * valore rappresenta l'importo della transazione
     * valuta rappresenta l'importo con cui l'importo è stata effettuata
     */
    public Importo(Valuta valuta) {
        valore=new BigDecimal(0);
        Objects.requireNonNull(valuta,"valuta non può essere null");
        this.valuta = valuta;

    }
    /**
     * Crea un importo
     * @param valore
     * @param valuta
     * @throws NullPointerException quando valore o valuta sono null
     * @throws IllegalArgumentException quando valore ha più di due cifre significative
     */
    public Importo(BigDecimal valore, Valuta valuta) {
        Objects.requireNonNull(valore,"Valore non può essere null");
        Objects.requireNonNull(valuta,"valuta non può essere null");
        if(valore.scale()>2){
            throw new IllegalArgumentException("valore non valido");
        }
        this.valore = valore;
        this.valuta = valuta;
    }
    /**
     * restiuscre il valore dell'importo
     * @return
     */
    public BigDecimal getValore() {
        return valore;
    }
    /**
     * restiuiscre la valuta dell'importo
     * @return
     */
    public Valuta getValuta() {
        return valuta;
    }
    
    /**
     * restiuiscre il valore dell'importo
     * @return
     */
    public int getValoreNum() {
        return valore.intValue();
    }
    /**
     * esegue la somma di due valori  importo e ne restiusce un nuovo importo
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    public Importo somma(Importo o)throws IllegalArgumentException {
        if(!(valuta.getSimbolo()==o.getValuta().getSimbolo())){
            throw new IllegalArgumentException("Le valute non corrispondono");
        }
        BigDecimal risultato = valore.add(o.valore);
        return new Importo(risultato, valuta);
    }
    /**
     * esegue la sottrazione di due valori  importo e ne restiusce un nuovo importo
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    public Importo sottrai(Importo o)throws IllegalArgumentException {
        if(!(valuta.getSimbolo()==o.getValuta().getSimbolo())){
            throw new IllegalArgumentException("Le valute non corrispondono");
        }
        BigDecimal risultato = valore.subtract(o.valore);
        return new Importo(risultato, valuta);
    }
    @Override
    public int compareTo(Importo o) {
         
        if(valuta.getSimbolo()==o.getValuta().getSimbolo()){
            return valore.compareTo(o.getValore());
        }else{
            throw new IllegalArgumentException();
        }
    }
    @Override
    public String toString() {
        return  valuta.getSimbolo()+":"+ valore;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((valore == null) ? 0 : valore.hashCode());
        result = prime * result + ((valuta == null) ? 0 : valuta.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Importo other = (Importo) obj;
        if (valore == null) {
            if (other.valore != null)
                return false;
        } else if (!valore.equals(other.valore))
            return false;
        if (valuta != other.valuta)
            return false;
        return true;
    }
    /**
     * Controllo se il numero è positivo
     * @return
     */
    public boolean isPositive(){
        return valore.compareTo(BigDecimal.ZERO) > 0;
    }
    
    
}
