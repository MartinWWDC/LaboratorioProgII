import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Overview: Rappresenteremo un 
 * 
 */
public class Playlist implements Iterable<Album.Brano>{
    /**
     * RI:
     * titolo non nullo
     * brani non può contenere duplicati 
     * 
     * AF:
     * titolo rappresenta il numero della playlist
     * durata rappresenta la somma della durata di tutti i brani 
     * brani eleco di tutte le canzoni presenti nella playlist
     */

    public String titolo;
    public Durata durata= new Durata(0);
    private final List<Album.Brano> brani = new ArrayList<>();





    public Playlist(String title) {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Titolo non può essere vuoto o nullo");
        }
        this.titolo = title;
    }
    /**
     * Permette di aggiungere traccia alla lista di brani contenuti nella playlist
     * @param traccia
     */
    public void aggiungi(Album.Brano traccia) {
        
    }
    /**
     * Permette di rimuovere traccia alla lista di brani contenuti nella playlist se non è presente non fa nulla
     * @param traccia
     */
    public void rimuovi(Album.Brano traccia) {
        
    }
    /**
     * Permette di fondere assieme due playlist
     * @param plist
     */
    public Playlist fusione(Playlist plist) {
        throw new UnsupportedOperationException("Unimplemented method 'brani'");

    }
    /**
     * resituisce un iteratore che restitutisce i brani che appartengono ad un determinato album
     * 
     * @return
     */
    public Iterator<Album.Brano> brani(Album al){

        throw new UnsupportedOperationException("Unimplemented method 'brani'");

    }
     /**
     * resituisce un iteratore che permette di avere tutti gli album presenti in una playlist
     * 
     * @return
     */
    public Iterator<Album.Brano> album(Album al){

        throw new UnsupportedOperationException("Unimplemented method 'album'");

    }

    @Override
    public Iterator<Album.Brano> iterator() {
         return Collections.unmodifiableCollection(brani).iterator();
    }
    



}
