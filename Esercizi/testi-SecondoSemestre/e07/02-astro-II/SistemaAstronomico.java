import java.util.ArrayList;
import java.util.List;

/**
 * Overview: questa classe di occupa di implementare un sistema Astonomico
 */
public class SistemaAstronomico {
    // Campi
    List<CorpoCeleste> sistema;

    /**
     * AF:-
     *
     * IR: sistema rappresenta un sistema astronomico contenente i corpi celesti
     * contenuti in sistema.
     */

    public SistemaAstronomico() {
        sistema = new ArrayList<CorpoCeleste>();
    }

    /**
     * Si occupa di aggiungere il Corpo Celeste passato come parametro al sistema
     * astronomico
     * 
     * @param p
     */
    public void add(CorpoCeleste p) {
        sistema.add(p);
    }

    // EFFECTS:Si occupa di ELIMINARE il corpo celeste passato come parametro al
    // sistema
    // astronomico (ad esempio a seguito dell'esplosione del corpo celeste)
    public void remove(CorpoCeleste p) {
        sistema.remove(p);
    }

    /**
     * questo metodo simula l'interazione tra i corpi celesti del sistema
     * astronomico
     * in n istanti di tempo consecutivi
     * 
     * @param n
     * @throws IllegalArgumentException
     */
    public void simula(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sistema.size(); j++) {
                for (int t = 0; t < sistema.size(); t++) {
                    sistema.get(j).aggiornaVelocita(sistema.get(t));
                }
            }
            for (int j = 0; j < sistema.size(); j++) {
                sistema.get(j).aggiornaPosizione();

            }

        }

    }

    public int getEnergia() {
        int n = 0;
        for (int i = 0; i < sistema.size(); i++) {
            n += sistema.get(i).energia();
        }
        return n;

    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < sistema.size(); i++) {
            str += sistema.get(i).toString() + "\n";
        }
        str += "Energia Totale:" + getEnergia();
        return str;
    }

}
