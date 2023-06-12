import java.util.Comparator;

public class OrdinaFasce implements Comparator<FasciaBetaoraria> {
    //OVERVIEW: Classe che implementa l'intefaccia Comparator per ordinare fasce betaorarie in base 
    //          Allorario d'inizio

    @Override
    public int compare(FasciaBetaoraria f1, FasciaBetaoraria f2) {
        if (f1.inizio().equals(f2.inizio())) return 0;
        boolean b = f1.inizio().confronta(f2.inizio());
        if (b) return -1;
        return 1;
    }
}