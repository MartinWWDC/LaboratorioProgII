import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Cassa:
 * lo scopo di questa classe è quello di rappresentare un cassa con al suo interno delle diverse valute
 */
public class Cassa implements Iterable<Importo> {
    /**
     * IR:
     * ogni importi deve avere la stessa valuta della riga a cui è asociato, nessun importo può essere nullo,  nessun importo può essere negativo
     * AF:
     * mappa contiene  una serie di importi che rappresentano i fondi presenti in cassa per singola valuta
     */
    private Map<Valuta,Importo> mapp;
    /**
     * Cassa crea una cassa vuota con tutte le valute disponibili impostate a zero
     */
    public Cassa() {
        mapp=new HashMap<Valuta,Importo>();
        for (Valuta val : Valuta.values()) { 
            mapp.put(val,new Importo(val));
        }
    }
    /**
     * aggiunge imp alla cassa nella sua specifica  cassa associata alla valuta
     * @param imp
     * @throws NullPointerException quanto imp è null
     * @throws RuntimeException quando la valuta dell'importo non è presente nella cassa
     */
    public void versamento (Importo imp)throws NullPointerException{
        Iterator<Importo> it=iterator();   
        Objects.requireNonNull(imp);
        while(it.hasNext()){
            Importo val=it.next();
            if(val.getValuta().getSimbolo()==imp.getValuta().getSimbolo()){
                if(!(mapp.get(val.getValuta()).somma(imp).getValoreNum()<0)){
                    mapp.replace(val.getValuta(),mapp.get(val.getValuta()).somma(imp));

                }else{
                    System.out.println("Saldo non sufficente");
                }
            }
            
        }

    }
    
    /**
     * sottrae imp alla cassa nella sua specifica  cassa associata alla valuta
     * @param imp
     * @throws NullPointerException quanto imp è null
     */
    public void prelievo (Importo imp){
        Iterator<Importo> it=iterator();   
        Objects.requireNonNull(imp);
        while(it.hasNext()){
            Importo val=it.next();
            if(val.getValuta()==imp.getValuta()){
                if(!(mapp.get(val.getValuta()).sottrai(imp).getValoreNum()<0)){
                    mapp.replace(val.getValuta(),mapp.get(val.getValuta()).sottrai(imp));

                }else{
                    System.out.println("Saldo non sufficente");
                }
            }
        }
    }    
    @Override
    public Iterator<Importo> iterator() {
       return new Iterator<Importo>() {
        private Valuta[] val= Valuta.values();
        private int i=-1;
        @Override
        public boolean hasNext() {

            return (i+1)<val.length;
        }

        @Override
        public Importo next() {
            
            if(!hasNext()){
                throw new OutOfMemoryError("errrore out of memory");
            }
            i++;

            return mapp.get(val[i]);
        }
        
       };
    }

    @Override
    public String toString() {
        String str="";
        Iterator<Importo> it=iterator();
        Importo val;
        while(it.hasNext()){
            val=it.next();

            str+=val.toString()+"\n";
        }

        return str;
    }
    

    





    
}
