import java.util.Iterator;
/**
 * PRogrammazioneSingolaData permette di  rappresentare le programmazioni che si svolgeranno soltanto una volta
 */
public class ProgrammazioneSingolaData implements Programmazione {
    /**
     * IR:
     * day >=1 && day<=31
     * AF:
     * rappresenta il giorno in cui avverrà  la proiezione
     */
    private int day;

  

    public ProgrammazioneSingolaData(int day) {
      if(day<1 || day>31){
        throw new IllegalArgumentException("day deve essere valido");
      }
      this.day=day;
      
    }


    @Override
    public Iterator<Integer> iterator() {
      return new Iterator<Integer>(){
        private int g=0;

        @Override
        public boolean hasNext() {
          g++; 
          return (g-1)==0;

        }

        @Override
        public Integer next() {
          if(g==0){
            return -1;
          }
          return day;  
        }

      
    };
    
}
}
