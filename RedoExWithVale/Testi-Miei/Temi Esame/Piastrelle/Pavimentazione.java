import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Pavimentazione implements Rivestimento{
   
    public static class Componente implements Rivestimento{
        public final Rivestimento rivestimento;
        public final int quantità;
    
       

        public Componente(final int quantità, final Rivestimento rivestimento) {
            this.rivestimento =
                Objects.requireNonNull(rivestimento, "Il rivestimento non può essere null.");
            if (quantità <= 0) throw new IllegalArgumentException("La quantità dev'essere positiva");
            this.quantità = quantità;
          }

        @Override
        public int costo() {
            return quantità*rivestimento.costo();
        }

        @Override
        public int superfice() {
            return quantità*rivestimento.superfice();
        }

    }
    private final Collection<Componente> componenti;


    public Pavimentazione(final Collection<Pavimentazione.Componente> componenti) {
        this.componenti = List.copyOf(componenti);
        if (componenti.isEmpty())
            throw new IllegalArgumentException("Ci deve essere sempre almeno una componente.");
    }

    @Override
    public int costo() {
        int totale=0;

        for(final Rivestimento r: componenti) totale+=r.costo();
        return totale;
        
    }

    @Override
    public int superfice() {
        int totale=0;

        for(final Rivestimento r: componenti) totale+=r.superfice();
        return totale;
    }
    
}
