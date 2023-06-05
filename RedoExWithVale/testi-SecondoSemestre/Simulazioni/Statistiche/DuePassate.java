import java.util.List;

public class DuePassate extends Statistica{
   

    private boolean checkV=false;
    private boolean checkM=false;
    private double varianza;
    private double media;

    public DuePassate(List<Double> dati) throws NullPointerException {
        super(dati);
    }

    @Override
    public double media() {
        if(checkM==false){
            double sum=0;
            for(int i=0;i<getN();i++){
                sum+=getElement(i);
            }
            media=sum/getN();
            checkM=true;
        }
        return media;
    }


    @Override
    public double varianza() {
        if(checkV==false){
            double sum=0;
            double mu=media();
            for(int i=0;i<getN();i++){
                sum+=Math.pow(getElement(i)-mu,2);
            }

            varianza=sum/(getN()-1);
            checkV=true;
        }
        return varianza;
    }

    @Override
    public void aggiungi(double elemento) throws NullPointerException {
        checkV=false;
        checkM=false;

        super.aggiungi(elemento);
    }

    @Override
    public void rimuovi(int index) throws IllegalArgumentException {
        checkV=false;
        checkM=false;

        super.rimuovi(index);
    }
    
    
}
