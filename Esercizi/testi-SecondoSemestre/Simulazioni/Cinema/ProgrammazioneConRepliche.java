import java.util.Iterator;
/**
 * questa classe sarà  responsabile di rappresentare la progrzmmazione con repliche
 * ovvero una programmazione che data un certo giorno ripeterà  per i successivi n giorni (anch'esso un campo) successivi
 */
public class ProgrammazioneConRepliche implements Programmazione  {
    /**
     * IR:
     * day >=1 && day<=31
     * rep >=1 && day+rep<=31
     * AF:
     * day: giorno della prima proiezione
     * rep: numero di ripetizioni che avverranno 
     */
    private int day;
    private int rep;

    /**
     * 
     * day >=1 && day<=31
     * rep >=1 && day+rep<=31
     * @param day
     * @param rep
     */    
   public ProgrammazioneConRepliche(int day, int rep) {
        this.day = day;
        this.rep = rep;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i=0;
            @Override
            public boolean hasNext() {
                if(i>=rep){
                    return false;
                }else{
                    return true;
                }
            }

            @Override
            public Integer next() {
                if(hasNext()){
                    i++;
                    return day+i-1;
                }else{
                    throw new IllegalAccessError("ouut of bound");
                }  
            }
            
        };
    }
    
}
