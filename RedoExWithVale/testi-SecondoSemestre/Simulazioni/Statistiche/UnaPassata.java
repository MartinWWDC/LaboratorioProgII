import java.util.List;

public class UnaPassata extends Statistica {
    

    private double media;
    private double varianza;
    private boolean check=false;
    public UnaPassata(List<Double> dati) throws NullPointerException {
        super(dati);
    }
    @Override
    public double media() {
        if(!check){
            calcolo();
        }
        return media;
    }

    private void calcolo() {
        double pow=0;
        double li=0;
        for(int i=0;i<getN();i++){
            pow+=Math.pow(getElement(i),2);
            li+=getElement(i);

        }
        media=li/getN();
        li=Math.pow(li,2);
        pow*=getN();
        varianza=(pow-li)/(getN()*(getN()-1));
        check=true;

    }

    @Override
    public double varianza() {
        if(!check){
            calcolo();
        }
        return varianza;
    }

    @Override
    public void aggiungi(double elemento) throws NullPointerException {
        check=false;
        super.aggiungi(elemento);
    }

    @Override
    public void rimuovi(int index) throws IllegalArgumentException {
        check=false;
        super.rimuovi(index);
    }
    
    
}
