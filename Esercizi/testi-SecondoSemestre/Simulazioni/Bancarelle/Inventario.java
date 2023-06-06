import java.util.Map;
import java.util.Objects;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Inventario implements Iterable<Giocattolo>{
 
    /**
     * Overview: le istanze di questa classe rappresentano un inventario di una bancarella
     */

    /**
     * IR: inventario rappresenta il numero di giocattoli per ogni tipo
     *     contenuti in una bancarella
     */
    //campi
    private final Map<Giocattolo, Integer> inventario = new HashMap<>();

    public Inventario() {}
    /**
     * Si occupa di aggiungere un Giocattolo all'interno  del nostro Inventarip 
     * @param g Giocattolo da aggiungere
     * @param n Numero di giocattoli da aggiungere 
     * @throws IllegalArgumentException Lanciata quando n è minore di 0
     */
    public void aggiungi(Giocattolo g, int n)throws IllegalArgumentException{
        Objects.requireNonNull(g, "Il giocattolo non può essere null.");
        if (n < 0){
            throw new IllegalArgumentException("non è possibile aggiungere all'inventario una quantità negativa di un giocattolo");
        }
        if (! this.contiene(g)) {
            this.inventario.put(g, n);
            return;
        }
        n = n + this.numeroGiocattoli(g);
        this.inventario.put(g, n);
    }
    
     /**
     * si occupa di rimuovere dal magazziono n giocattoli del tipo specificato
     * solleva un eccezione illegalargument se n<0, illegalaction se g non è presente nell'inventario o 
     * n è maggiore del numero di giocattoli di tipo g in inventario
     * @param g 
     * @param n
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public void rimuovi(Giocattolo g, int n){
        Objects.requireNonNull(g, "Il giocattolo non può essere null.");
        if(n<0){
            throw new IllegalArgumentException("non è possibile rimuovere all'inventario una quantità negativa di un giocattolo");

        }   
        if(!(this.contiene(g))){
            throw new RuntimeException("non è possibile rimuovere all'inventario un oggetto non presente");
            
        }  
        if(this.numeroGiocattoli(g)<n){
            throw new RuntimeException("non è possibile rimuovere all'inventario una quantità MAGGIORE rispetto al numero di oggetti presenti nell'inventario");

        }

        this.inventario.put(g, numeroGiocattoli(g)-n);
           
    }
    /**
     * Restiuisce il numero di giocattotili g presenti nell'inventario 
     * @param g
     * @return
     */
    public int numeroGiocattoli(Giocattolo g){
        Objects.requireNonNull(g, "Il giocattolo non può essere null.");
        if (! this.contiene(g)) return -1;
        return this.inventario.get(g);

    }

    public boolean contiene(Giocattolo g) {
        Objects.requireNonNull(g, "Il giocattolo non può essere null.");

        return this.inventario.containsKey(g);
    }

    @Override
    public Iterator<Giocattolo> iterator() {
        final List<Giocattolo> giocattoli = new ArrayList<>(inventario.keySet());
        Collections.sort(
            giocattoli,
            new Comparator<Giocattolo>() {
              @Override
              public int compare(Giocattolo o1, Giocattolo o2) {
                return o1.toString().compareTo(o2.toString());
              }
            });
        return giocattoli.iterator();
      }




//solo :(
    @Override
    public String toString() {
        return "inventario: {" + inventario + '}';
    }

  
    
}
