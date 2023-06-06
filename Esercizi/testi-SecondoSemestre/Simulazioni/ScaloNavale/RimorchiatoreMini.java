import java.util.Objects;

public class RimorchiatoreMini implements Rimorchiatore {

    @Override
    public void sposta(Molo partenza, Molo arrivo, int quantità) {
        Objects.requireNonNull(partenza, "Il primo molo non può essere null.");
        Objects.requireNonNull(arrivo, "Il secondo molo non può essere null.");
        if (quantità <= 0) throw new IllegalArgumentException("Non puoi spostare meno di 0 navi.");
        if (quantità < partenza.getNNavi()) throw new IllegalArgumentException("Non ci sono abbastanza navi da rimuovere.");
        for (int i=0; i<quantità; i++) {
            Nave nave = partenza.salpa();
            arrivo.attracca(nave);
        }
    }
   
    
}
