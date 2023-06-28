/*
 * questa interfaccia descrive i comportamenti che deve avere una programmazione
 * è una sequenza (non vuota, ma eventualmente di un solo elemento e in ordine strettamente crescente) 
 * di interi compresi tra 1 e 31 
 * che rappresentano i giorni del mese in cui si svolge la proiezione
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Programmazione extends Iterable<Integer> {

    /**
     * 
     * Questo meteodo permette di controllare se l'intero g sia o meno compreso tra i giorni che rappresenta la programmazione 
     * @param g
     * @return
     * @throws IllegalArgumentException
     */
    default boolean isInProgrammazione(int g) throws IllegalArgumentException{
            Iterator<Integer> it = iterator();
        
        while (it.hasNext()){
            if(it.next()==g){
               return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<Integer> iterator();

    
    /**
     * Restiuisce la lista di giorni in cui avviene la programmazione
     * @return
     */
    default List<Integer> getGiorni(){
        List<Integer> arr= new ArrayList<Integer>();
        Iterator<Integer> it= iterator();
        while(it.hasNext()){
            arr.add(it.next());
        }

        return arr;
    }


    

}
