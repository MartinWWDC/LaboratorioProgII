import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Overview: la classe Statistica fornisce il procedimento per calcolare la media e la varianza di un elenco di valori double
 * 
 */
public abstract class Statistica {

    /**
     * IR:  
     * dati non può essere  null
     * nessun elemento deve essere null
     * 
     * AF:
     * dati rappresenta la serie di dati che comporrano la nostra statistica
     */
    protected List<Double> dati=new ArrayList<Double>();

    
    

    public Statistica(List<Double> dati)throws NullPointerException {
        Objects.requireNonNull(dati, "il vettore non può essere null");
        for(int i=0;i<dati.size();i++){
            Double v=dati.get(i);
            aggiungi(v);
        }

    }
   
    /**
     * Questo metodo si occupa di aggiungere l'elemento  all' interno di dati 
     * @param elemento
     * @throws NullPointerException
     */
    public void aggiungi(double elemento)throws NullPointerException{
        Objects.requireNonNull(elemento, "tutti gli elementi non devono essere null");
        dati.add(elemento);

    }
    /**
     * Questo metodo si occupa di rimuovere l'elemento  all' interno di dati 
     * @param elemento
     * @throws IllegalArgumentException se la posizione non è appartenente a dati
     */
    public void rimuovi(int index)throws IllegalArgumentException{
        if(index<0 || index>= getN()){
            throw new IllegalArgumentException("elemento out of bound");
        }
        dati.remove(index);

    }
    
    /**
     * Restiuisce la grandezza della statistica
     * @return
     */
    public int getN() {
        return dati.size();
    }

    /**
     * Questo metodo si occupa di restiuire l'elemento in posizione index
     * @param index
     * @return
     * @throws NullPointerException
     */
    public double getElement(int index)throws NullPointerException {
        if(index<0 || index>= getN()){
            throw new IllegalArgumentException("elemento out of bound");
        }
        return dati.get(index);
    }
    /**
     * Questo metodo permette di calcolare la media dei dati  all' interno della statistica
     * @return
     */
    public abstract double media();
    /**
     * Questo metodo permette di calcolare la varianza dei dati  all' interno della statistica
     * @return
     */
    public abstract double varianza();

    @Override
    public String toString() {
        String msc="";
        for(int i=0;i<getN();i++){
            msc+=dati.get(i)+" ";
        }
        return msc;
    }
    





    
}
