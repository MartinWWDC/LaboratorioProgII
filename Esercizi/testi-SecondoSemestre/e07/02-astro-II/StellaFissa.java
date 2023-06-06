import java.io.PushbackInputStream;

public class StellaFissa extends CorpoCeleste {

    private final Punto posizione, velocita;

    public StellaFissa(String nome, int x, int y, int z) {
        super(nome);
        posizione = new Punto(x, y, z);
        velocita = new Punto(0, 0, 0);

    }

    @Override
    public Punto getPosizione() {
        return posizione;
    }

    @Override
    public Punto getVelocita() {
        return velocita;
    }

    @Override
    public void aggiornaPosizione() {

    }

    @Override
    public String toString() {
        return "Stella " + this.Nome + " : in posizione: " + posizione;
    }

    @Override
    public void aggiornaVelocita(CorpoCeleste c) {

    }

}
