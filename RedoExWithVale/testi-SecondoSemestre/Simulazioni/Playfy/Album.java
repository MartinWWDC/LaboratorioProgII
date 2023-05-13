import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Overview: Una classe che rappresenta un album
 */
public class Album  implements Iterable<Album.Brano>{
    
    public class Brano{
        /**
         * AF: Titolo rappresneterà il titolo del brano  
         * Durata la durata del brano  
         * RI: Titolo != "" && Titolo!= null
         * Durata != null
         */
        public final String titolo;
        private final Durata durata;


        public Brano(String titolo,Durata durata){
            if(!(titolo!="" && titolo!=null)) throw new IllegalArgumentException("Titolo non può essere vuoto o nullo");
            Objects.requireNonNull(durata,"La durata non può essere nulla");
            this.titolo=titolo;
            this.durata=durata;
        }

        /**
         * PErmette di sapere a quale album appartiene un brano 
         * @return
         */
        public Album album(){
            return Album.this;
        }

        /**
         * Resituisce la durata di un brano
         * @return
         */
        public Durata getDurata() {
            return durata;
        }
          /**
         * Consente di determinare se questo brano appartiene al medesimo album di quello dato.
         *
         * @param album l'album del quale è da verificare l'appartenenza.
         * @return {@code true} se e solo se questo brano appartiene all'album dato.
         * @throws NullPointerException se l'album è {@code null}.
         */
        public boolean appartiene(final Album album) {
            return Album.this.equals(Objects.requireNonNull(album, "L'album non può essere null."));
        }

        public String aString(boolean conAlbum){
            return String.format(
                "\"%s\" (%s)%s", titolo, durata, conAlbum ? ", (da \"" + album().titolo + "\")" : "");
          }

        @Override
        public String toString() {
            return aString(false);
        
        }
                


    }
    /**
     * AF: Titolo rappresneterà il titolo dell'album 
     * Durata la sua durata complessiva
     * brani: la collezione con tutti i brani contenuti 
     * 
     * RI: Titolo != "" && Titolo!= null
     * Durata != null
     * brani non deve contenere duplicati o oggetti nulli 
     */
    public final String titolo;
    public final Durata durata;
    private final Brano[] brani;


    public Album(String titolo, List<String> Titoli, List<Durata> durata) {
        if (Titoli.size() != durata.size()) {
            throw new IllegalArgumentException("Non ci sono lo stesso numero di titoli e di durate");
        }
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Titolo non può essere vuoto o nullo");
        }
        this.titolo = titolo;
        int max=0;
        Brano[] arrB = new Brano[durata.size()];
        for (int i = 0; i < Titoli.size(); i++) {
            Objects.requireNonNull(durata.get(i), "tutte le durate non devono essere  null");
            arrB[i] = new Brano(Titoli.get(i), durata.get(i));
            max+=durata.get(i).secondi();
        }
        brani = arrB;
        this.durata=new Durata(max);

    }
    /**
     * Questo metodo permette di ottenere un brano partendo dal suo titolo 
     * @param title
     * @return
     * @throws IllegalArgumentException viene lanciata quando il testo è o vuoto o nullo 
     */
    public Brano getTrackTitle(String title) throws IllegalArgumentException{
        throw new UnsupportedOperationException("da implementa");

    }
     /**
     * Questo metodo permette di ottenere un brano partendo dal suo indice di posizione nell'album 
     * @param index
     * @return
     * @throws IllegalArgumentException viene lanciata quando index è minore di 0 oppure supera il numero di tracce presenti nell'album
     */
    public Brano getTrackFromIndex(int index) throws IllegalArgumentException{
        throw new UnsupportedOperationException("da implementa");

    }

    public int getNTrack() {
        return brani.length;
    }
      /**
     * Questo metodo permette di ottenere un indice di posizione partendo dalla traccia
     * @param index
     * @return
     * @throws IllegalArgumentException viene lanciata quando index è minore di 0 oppure supera il numero di tracce presenti nell'album
     */
    public Brano getIndexFromTrack(Brano brano) throws IllegalArgumentException{
        throw new UnsupportedOperationException("da implementa");

    }

    @Override
    public String toString() {
        return "Album [titolo=" + titolo + ", durata=" + durata + ", brani=" + Arrays.toString(brani) + "]";
    }
    @Override
    public Iterator<Album.Brano> iterator() {

        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    
    
    
}
