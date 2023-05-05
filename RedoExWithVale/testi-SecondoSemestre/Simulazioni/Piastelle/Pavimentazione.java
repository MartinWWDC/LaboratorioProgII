import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Iterator;



public class Pavimentazione implements Rivestimento,Iterable<Pavimentazione.Componente>{

    public static class Componente implements Rivestimento{
        public int quantità;
        public Rivestimento rivestimento;
        

        public Componente(int quantità, Rivestimento rivestimento) {
            if (quantità <= 0) throw new IllegalArgumentException("La quantità dev'essere positiva");
            this.quantità = quantità;
            this.rivestimento = Objects.requireNonNull(rivestimento);
        }

        @Override
        public int costo() {
            return rivestimento.costo()*quantità;
        }

        @Override
        public int superfice() {
            return rivestimento.superfice()*quantità;
        }

    }
      /**
   * La collezione di componenti compresi in questa pavimentazione, non è {@code nulL}, non è vuota
   * e non contiene {@code null}.
   */
    private final Collection<Componente> componenti;


    public Pavimentazione(Collection<Pavimentazione.Componente> componenti) {
        if(componenti.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.componenti = List.copyOf(componenti);
    }

    @Override
    public int costo() {
      int totale = 0;
      for (final Rivestimento r : componenti) totale += r.costo();
      return totale;
    }
  
    @Override
    public int superfice() {
      int totale = 0;
      for (final Rivestimento r : componenti) totale += r.superfice();
      return totale;
    }
    

    @Override
    public Iterator<Pavimentazione.Componente> iterator() {
      return componenti.iterator();
    }    
}
