import java.util.Objects;

public record Betaorario(int ore, int minuti) {
    //OVERVIEW: Record che rappresenta un betaorario, composto da betaore
    //  (tra 0 e 30 compresi)  e betaminuti, compreso tra 0 e 79 inclusi.

    /*
     * AF = Un betaorario è rappresentato come segue betaore:betaminuti
     * RI = ore deve essere compreso tra 0 e 30 inclusi, minuti deve essere compreso tra 0 e 79 inclusi
     */
    //EFFECTS: Lancia IllegalArgumentException se ore < 0 o ore > 30 o minuti <0 o minuti > 79
    public Betaorario {
        if (ore<0||ore>30||minuti<0||minuti>79)
            throw new IllegalArgumentException("Betaorario non valido");
    }

    //EFFECTS: Confronta il betaoraro con quello passato come
    //         argomento. true se this viene prima
    //         Lancia NullPointerException se b == null
    public boolean confronta(final Betaorario b) {
        Objects.requireNonNull(b, "Non può essere null.");
        if(ore>b.ore()) return false;
        if(ore<b.ore()) return true;
        if(minuti>b.minuti()) return false;
        if(minuti<b.minuti()) return true;
        return false;
    }
    //EFFETCS: Converte in betaminuti
    public int betaminuti() {
        return (ore*80)+minuti;
    }
    //EFFECTS: restituisce il betaorario sommando a this
    //         i minuti dati in input
    public Betaorario somma(final int n) {
        if (minuti + n <= 79) return new Betaorario(ore, minuti+n);
        int resto = minuti + n - 80;
        int minutiNew = 0;
        int oreNew = ore+1;
        for (int i = 0; i<resto; i++) {
            minutiNew += 1;
            if (minutiNew>79) {
                minutiNew = 0;
                oreNew ++;
            }
            if (oreNew>30) {
                oreNew=0;
            }
        }
        return new Betaorario(oreNew, minutiNew);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ore<10) sb.append("0");
        sb.append(ore+":");
        if (minuti<10) sb.append("0");
        sb.append(minuti);
        return sb.toString();
    }
}