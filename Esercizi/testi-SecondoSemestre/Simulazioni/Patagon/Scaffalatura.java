import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Overview: PErmette di implementare uno scaffale per contenete pacchi 
 */
public class Scaffalatura {
    /**
     * IR:
     * scaffale: non deve essere null non deve contenere oggetti null
     * 
     * AF:
     * scaffale rappresenta la pila di pacchi
     */
    private List<Pacco> scaffale;
   

    public Scaffalatura() {
        scaffale= new ArrayList<Pacco>();
    }
    /**
     * aggiunge p alla nostra scaffalatura
     * @param p
     * @throws NullPointerException viene lanciata se p è null
     */
    public void aggiungi(Pacco p) throws NullPointerException{
        Objects.requireNonNull(p,"p non può essere null");
        scaffale.add(p);
    } 
    /**
     * rimuove l'ultimo elemento appartenenete alla scaffalatura
     * @return Ritorna l'ultimo pacco dalla pila
     * @throws IllegalAccessException lanciata quando la pila è vuota
     */
    public Pacco rimuovi() throws IllegalAccessException{
        Pacco p=scaffale.get(0);
        scaffale.remove(0);
        return p;
    } 
    /**
     * Restituisce l'altezza  dell'ultimo elemeno dello scaffale 
     * @return
     */
    public int getAltezzaPrim(){
        return scaffale.get(0).altezza();
    }
    /**
     * Restituisce il numero di pacchi presenti nello scaffale
     * @return
     */
    public int getNPacchi(){
        return scaffale.size();
    }


    @Override
    public String toString() {
        return "Scaffalatura [scaffale=" + scaffale + "]";
    }

    
}
