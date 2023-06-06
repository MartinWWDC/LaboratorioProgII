import java.util.Map;
import java.util.Objects;

public abstract class AbstractListinoUnitario {
    private final Map<Giocattolo,Integer> prezzoUnitario;

    public AbstractListinoUnitario(Map<Giocattolo, Integer> prezzoUnitario) {
        for (Map.Entry<Giocattolo, Integer> e : prezzoUnitario.entrySet()) {
            final Giocattolo giocattolo = Objects.requireNonNull(e.getKey(), "La mappa non può contenere chiavi null.");
            final Integer num = Objects.requireNonNull(e.getValue(), "La mappa non può contenere valori null.");
            if (num <= 0)
            throw new IllegalArgumentException("Il prezzp di " + giocattolo + " deve essere positivo");
            this.prezzoUnitario.put(giocattolo, num);
        }
    }
    
}
