public interface Matrice {
    
    /**
     * Permette di ottenere la dimensione del vettore
     * @return la dimensione
     */
    int dim();

    /**
     * Permette di ottenere il valore nell'i-esima riga e j-esima colonna della matrice
     * @param i posizione dell'elemento
     * @return elemento in i-esima posizione
     * @throws IllegalArgumentException se i è maggiore della dimensione o minore di 0
     */
    int val(final int i,final int j)throws IllegalArgumentException;
    /**
     * Moltiplica la matrice per una costante alpha
     * @param alpha la costante per cui motiplicare la matrice
     * @return 
     */
    Matrice per(final int alpha); 
    /**
    * Moltiplica la matrice per un altra matrice
    * @param
    * @return 
    */
   Matrice per(Matrice B);
    /**
     * permette di eseguire la somma tra due Matrici
     * @param v
     * @return
     */
    Matrice più(final Matrice v);
    /**
     * Controlla che due matrici abbiano la stessa dimensione
     * @param v
     * @return
     */

    default boolean checkMM(Matrice v){
        return dim()==v.dim();
    }
    
}
