import java.util.List;

public class Induttiva extends Statistica{

  
    public Induttiva(List<Double> dati) throws NullPointerException {
        super(dati);
    }


    @Override
    public double varianza() {
        if (getN() < 2) throw new IllegalArgumentException("Non si può calcolare la varianza su meno di 2 elementi");
        double varianza = 0, media = 0, vecchiaMedia = 0;
        for (int i=0; i<getN(); i++) {
            vecchiaMedia = media;
            media += (getElement(i)-media)/(i+1);
            varianza += (getElement(i)-media)*(getElement(i)-vecchiaMedia);
        }
        return varianza/(getN()-1);
    }

    
    @Override
    public double media() {
        if (getN() < 1) throw new IllegalArgumentException("Non si può calcolare la media su meno di un elemento.");
        double media = 0;
        for (int i=0; i<getN(); i++) {
            media += (getElement(i)-media)/(i+1);
        }
        return media;
    }
}