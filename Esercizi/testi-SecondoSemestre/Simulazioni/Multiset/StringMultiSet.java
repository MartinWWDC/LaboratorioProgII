/**
 * Overview: questa interfaccia definisce il tipo multiset, un insieme con possibili elementi ripetuti, in cui non conta
 * l'ordine degli elementi
 */
public interface StringMultiSet extends Iterable<String> {
  /**
   * Permette al MultiSet di aggiungere elementi al suo interno
   * @param s Elemento da aggiungere
   * @return Restituisce la sua molteplicità in seguito all'aggiunta 
   * @throws IllegalArgumentException solleva un eccezione se la stringa che si vuole aggiungere è nulla
   */

  int add(String s) throws IllegalArgumentException;

  /**
   * Permette al MultiSet di eliminare elementi al suo interno 
   * @param s Elemento da eliminare
   * @return Restituisce la sua molteplicità prima della rimozione
   */
  int remove(String s);
  /**
   * Permette di controllare se un elemento sia o meno presente all'interno del multiset  restituendo un valore booleano
   * @param s
   * @return
   */
  boolean contains(String s);

  /**
   * Permette di conoscere la molteplicità (num di volte che s è contenuto nel multiset) di un elemento
   * @param 
   * @return Restituisce la molteplicità di s
   */
  int multiplicity(String s);
  /**
   * Restiuisce la cardinalità del multiset
   * @return
   */
  int size();

  /**
   * Permette l'operazione insiemistica di unione estesa ai multiset
   * @param un multiset con cui si eseguirà l'unione
   * @return il multiset unione che ha come supporto l'unione dei supporti e come molteplicità 
   *        degli elementi il massimo tra la molteplicità di uno stesso elemento nei 2 insiemi
   */
  StringMultiSet union(StringMultiSet o);
  /**
   * Permette l'operazione insiemistica di Intersezione estesa ai multiset
   * @param s Elemento da eliminare
   * @return Restituisce la sua molteplicità prima della rimozione
   */
  StringMultiSet intersection(StringMultiSet o);
}
