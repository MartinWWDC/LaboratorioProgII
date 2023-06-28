import java.util.Iterator;
/**
 * Overview:
 * Programmazione che si ripete  ogni un certo numero di giorni 
 */
public class ProgrammazioneConIntervallo implements Programmazione{
    /**
     * IR:
     * Day: 1<= day<= 31
     * intervallo >0
     * 
     * AF:
     * day rappresenta il primo giorno in cui si verifica la programmazione
     * intervallo rappresenta l'intervallo che decorre tra una  data e l'altra 
     */
    private int day;
    private int intervallo;
    /**
     * Costruttore 
     * @param day 1<=day<=31
     * @param intervallo intervallo >0
     * @throws IllegalArgumentException quando day o intervallo non rispettano le condizioni imposte 
     */
    public ProgrammazioneConIntervallo(int day, int intervallo) {
        if(!(intervallo>0 || (day>=1 && day<=31) )){
            throw new IllegalArgumentException("Intervallo e day contengono valori non consentiti");
        }
        this.day = day;
        this.intervallo = intervallo;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            int counter=0;
            @Override
            public boolean hasNext() {
               
                return !(counter+day+1>31);
               
            }

            @Override
            public Integer next() {
                if(hasNext()){

                    counter+=day;
                    if(!(counter==day)){
                        counter++;
                    }
                    return counter;
                }else{
                    throw new IllegalAccessError("Non ci sono altri elementi");
                }
            }

        };
    }
    
}
