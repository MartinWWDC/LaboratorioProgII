import java.time.Duration;
import java.util.Objects;

/**
 * Overview: Durata permette di rappresentare un determianto   che rappresenta una durata (non negativa).
 *
 */
 
 public record Durata(int secondi) {
    /**
     * AF: 
     * 
     * RI: secondi non dovrà essere minore di 0
     */


    public Durata{
        if(secondi<0)throw new IllegalArgumentException();
    }
    /**
     * Permette di ottenere il tempo in formato HH:MM:SS
     * @return
     */
    public String toHHMM(){
        long HH = secondi / 3600;
        long MM = (secondi % 3600) / 60;
        long SS = secondi % 60;

        return String.format("%02d:%02d:%02d", HH, MM, SS);
    }
    /**
     * Permette di sommare tra loro due durate non nulle
     * @param d 
     * @return
     */
    public Durata Somma(Durata d){
        Objects.requireNonNull(d,"Non puoi passare una stringa nulla");
        return new Durata(secondi+d.secondi);
    }
    /**
     * Permette di sommare tra loro due durate non nulle
     * @param d 
     * @return
     */
    public Durata Sottrai(Durata d){
        Objects.requireNonNull(d,"Non puoi passare una stringa nulla");
        return new Durata(secondi-d.secondi);
    }

    @Override
    public String toString(){
        return toHHMM();
    }

}
