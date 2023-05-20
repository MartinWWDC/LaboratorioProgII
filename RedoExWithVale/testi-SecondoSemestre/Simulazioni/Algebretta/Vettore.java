/** Interfaccia che descrive il contratto di un vettore immutabile a valori interi. */

public interface Vettore{

    /**
     * Permette di ottenere la dimensione del vettore
     * @return la dimensione
     */
    int dim();

    /**
     * Permette di ottenere il valore nell'i-esima componente del vettore
     * @param i posizione dell'elemento
     * @return elemento in i-esima posizione
     * @throws IllegalArgumentException se i è maggiore della dimensione o minore di 0
     */
    int val(final int i)throws IllegalArgumentException;
    /**
     * Moltiplica il vettore per una costante alpha
     * @param alpha la costante per cui motiplicare il vettore
     * @return il nuovo vettore
     */
    Vettore per(final int alpha);
    /**
     * permette di eseguire la somma tra due vettori
     * @param v
     * @return
     */
    Vettore più(final Vettore v);
    /**
     * Controlla che due vettori abbiano la stessa dimensione
     * @param v
     * @return
     */

    default boolean check(Vettore v){
        return dim()==v.dim();
    }
     
    default boolean checkVM(Matrice v){
        return dim()==v.dim();
    }
    


    
}