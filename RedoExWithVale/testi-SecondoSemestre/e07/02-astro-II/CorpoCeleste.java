/**
 * Overview: Implementa la struttura dei corpi celesti
 */
public abstract class CorpoCeleste {
    String Nome;

    public CorpoCeleste(String nome) {
        Nome = nome;
    }

    /**
     * Permette di ricevere la posizione del corpo celeste in output
     * 
     * @return
     */
    public abstract Punto getPosizione();

    /**
     * Permette di ricevere la velocità del corpo celeste sotto forma di posizione
     * 
     * @return
     */

    public abstract Punto getVelocita();

    /**
     * Permette di aggiornare la posizione del corpo celeste
     */
    public abstract void aggiornaPosizione();

    /**
     * Permette di aggiornare la velocità del corpo celeste
     */
    public abstract void aggiornaVelocita(CorpoCeleste c);

    public int energia() {
        return getPosizione().norma() * getVelocita().norma();
    }
}
