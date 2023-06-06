
public class Pianeta extends CorpoCeleste {
    private Punto posizione, velocita;

    public Pianeta(String nome, int x, int y, int z) {
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
        posizione = posizione.somma(velocita);
    }

    @Override
    public void aggiornaVelocita(CorpoCeleste c) {
        if (posizione.x > c.getPosizione().x)
            velocita = velocita.somma(new Punto(-1, 0, 0));
        else if (posizione.x < c.getPosizione().x)
            velocita = velocita.somma(new Punto(1, 0, 0));

        if (posizione.y > c.getPosizione().y)
            velocita = velocita.somma(new Punto(0, -1, 0));
        else if (posizione.y < c.getPosizione().y)
            velocita = velocita.somma(new Punto(0, 1, 0));

        if (posizione.z > c.getPosizione().z)
            velocita = velocita.somma(new Punto(0, 0, -1));
        else if (posizione.z < c.getPosizione().z)
            velocita = velocita.somma(new Punto(0, 0, 1));

    }

    @Override
    public String toString() {
        return "Pianeta " + Nome + " : " + posizione + ", velocita:" + velocita + " energia:" + energia();
    }

}
