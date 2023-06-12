import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CautoRobot implements Robot{
    private List<Pacco> coda=new ArrayList<Pacco>(); 
    private int altezzaMax;

    
    public CautoRobot(int altezzaMax) {
        if(altezzaMax<=0){
            throw new IllegalArgumentException("altezzaMax deve essere maggiore di 0");
        }
        this.altezzaMax = altezzaMax;

    }

    /**
     * Non Funge
     */
    @Override
    public int sposta(Scaffalatura a, Scaffalatura b, int n) throws IllegalAccessException {
        Objects.requireNonNull(a, "scaffale null");
        Objects.requireNonNull(b, "scaffale null");
        if(n<=0){
            throw new IllegalArgumentException("numero di pacchi negativo");
        }
        int p=0;
        int oldP=1;
        for(int i=0;i<n;i++){
            if(oldP!=p){
                oldP=p;
                coda.add(a.rimuovi());
            }else{
                if(getSomma()+a.getAltezzaPrim()<=altezzaMax){
                    coda.add(a.rimuovi());

                }else{
                    p++;
                    coda.clear();
                }

            }
            
            System.out.println(coda);;
        }
        return p+1;
    }
    /**
     * Restituisce la somma delle altezze dei pacchi presenti sul piano di carico
     * @return
     */
    private int getSomma(){
        int max=0;
        for(int i=0;i<coda.size();i++){
            max+=coda.get(i).altezza();
        }
        return max;
    }
}
