/**
 * OVERVIEW: Le istanze di questa classe rappresentano dei punti 3d a coordinate
 * intere.
 * Gli oggetti di questo tipo sono immutabili.
 * UN PUNTO TIPICO è [x, y, z].
 */

public class Punto {
    /**
     * AF:
     */
    /**
     * RI: Rappresenta un punto tridimensionale
     */
    final int x;
    final int y;
    final int z;

    public Punto(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

    /**
     * EFFECTS: restituisce un nuovo punto dato dalla somma delle coordinate
     * di this e q
     */
    public Punto somma(Punto q) {
        return new Punto(x + q.x, y + q.y, z + q.z);
    }

    /**
     * EFFECTS: restituisce un nuovo punto dato dalla differenza delle coordinate
     * di this e q
     */

    public Punto sottrai(Punto q) {
        return new Punto(x - q.x, y - q.y, z - q.z);

    }

    /**
     * EFFECTS: restituisce la somma dei valori assoluti delle cordinate di this
     */
    public int norma() {
        int a = x;
        int b = y;
        int c = z;
        if (a < 0)
            a = -a;
        if (b < 0)
            b = -b;
        if (c < 0)
            c = -c;
        return (a + b + c);

    }
}