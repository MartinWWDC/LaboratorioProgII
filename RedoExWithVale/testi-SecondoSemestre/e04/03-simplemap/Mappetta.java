import java.util.ArrayList;
import java.util.List;

/**
 * OVERVIEW: questa classe rappresenta una mappa da stringa ad intero
 */

public class Mappetta {
    // Campi

    private record elemento(String key, int element) {
        public elemento {
            if (key == "" || key == null) {
                throw new IllegalArgumentException("Key non può essere null");
            }
        }

        @Override
        public String toString() {
            return "[" + key + ":" + element + "]";
        }

    }

    private List<elemento> map;

    /**
     * AF: 2 elementi di mappa non possono avere la stessa key (in contesto case
     * sensitive). Ogni valore di key non può essere nullo
     * 
     * IR: Mappetta rappresenta un dizionario che mappa(/ assegna) ad ogni key
     * in
     * elemento l'intero element
     */

    public Mappetta() {
        map = new ArrayList<elemento>();
    }

    /**
     * REQUIRES:--
     * MODIFIES:--
     * EFFECTS: metodo che restituiscetrue se la stringa passata è già presente come
     * key in un elemento della Mappettapa,false altrimenti
     */
    /**
     * Ritorna un valore boolenano se il valore key è gia presente o meno sotto
     * forma di chiave all'iterno della mappa
     * 
     * @param key
     * @return
     */
    public boolean isIn(String key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).key.equals(key)) {
                return true;
            }
        }
        return false;

    }

    /**
     * REQUIRES:--
     * MODIFIES:--
     * EFFECTS: metodo che inserisce nella mappa value mappato conn key, se la key è
     * già
     * presente value viene lanciata un eccezione
     */
    /**
     * 
     * Questo metodo si occupa di inserire all'interno della mappa l'elemento
     * passato come parametro, e se dovesse essere già presente il valore viene
     * lanciata un eccezione
     * 
     * @param key
     * @param value
     * @throws IllegalArgumentException
     */
    public void put(String key, int value) throws IllegalArgumentException {
        if (!isIn(key)) {
            elemento e = new elemento(key, value);
            map.add(e);
        } else {
            throw new IllegalArgumentException("chiave già utilizzata nella mappa!");
        }

    }

    /**
     * REQUIRES:--
     * MODIFIES:--
     * EFFECTS: metodo che rimuove dalla mappa l'elemento corrispondente alla chiave
     * passata
     * passata
     * 
     */
    public void remove(String key) {
        if (isIn(key)) {
            int i = getPos(key);
            map.remove(i);
        }
    }

    /**
     * REQUIRES:--
     * MODIFIES:--
     * EFFECTS: metodo che restituisce la posizione di un elemento, identificato
     * dalla chiave passata, all'interno della mappa
     * 
     */
    private int getPos(String key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).key.equals(key)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public String toString() {
        return "" + map;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Mappetta))
            return false;
        Mappetta mapp = (Mappetta) obj;

        return map.equals(mapp.map);
    }

    @Override
    public int hashCode() {
        int code = 0;
        for (int i = 0; i < map.size(); i++) {
            code += map.get(i).key.hashCode() + map.get(i).element;
        }
        return code;
    }

    public boolean repOK(ArrayList<elemento> ele) {
        List<String> chiavi = new ArrayList<String>();
        for (int i = 0; i < ele.size(); i++) {
            if (chiavi.contains(ele.get(i).key)) {
                chiavi.add(ele.get(i).key);

            } else {
                return false;
            }
        }
        return true;
    }
}
