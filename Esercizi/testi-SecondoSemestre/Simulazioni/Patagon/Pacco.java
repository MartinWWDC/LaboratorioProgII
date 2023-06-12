import java.util.Objects;

/**
 * Overview: Questa classe si occuperà di rappresentare un pacco
 */
public record Pacco(String categoria,int altezza){
    /**
     * IR: Categoria non potrà mai essere ne vuote ne null, quindi dovrà avere lunghezza di almeno 1 carattere
     * Altezza: dovrà essere maggiore di 0
     */
    /**
     * AF: categoria: rappresenta la categoria a cui appartiene il pacco
     * altezza: rappresenta l'altezza del pacco
     */
    /**
     * Costruttore
     * @param categoria
     * @param altezza
     * @throws NullPointerException se categoria è null
     * @throws IllegalArgumentException se categoria.length è <1
     * @throws IllegalArgumentException se altezza è <=0
     */
    public Pacco(String categoria,int altezza){
        Objects.requireNonNull(categoria, "categoria non deve essere null");
        
        
        if(categoria.length()<1 || categoria.isBlank()){
            throw new IllegalArgumentException("deve contenere almeno un carattere");
        }
        if(altezza<=0){
            throw new IllegalArgumentException("altezza deve contenere maggiore di 0");
        }
        this.categoria=categoria;
        this.altezza=altezza;

    }

    @Override
    public String toString() {
        String str="";
        str+="[Cat: "+categoria+", altezza: "+altezza+"]";
        return str;
    }
   
}