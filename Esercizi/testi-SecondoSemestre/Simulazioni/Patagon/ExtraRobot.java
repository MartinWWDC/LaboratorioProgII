import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Overview: un "extra" robot in grado di spostare un numero potenzialmente illimitato di
 * pacchi alla volta; 
 */
public class ExtraRobot implements Robot {
    
    private List<Pacco> coda=new ArrayList<Pacco>(); 
    public ExtraRobot() {}

    @Override
    public int sposta(Scaffalatura a, Scaffalatura b, int n) throws IllegalAccessException {
        Objects.requireNonNull(a, "scaffale null");
        Objects.requireNonNull(b, "scaffale null");
        if(n<=0){
            throw new IllegalArgumentException("numero di pacchi negativo");
        }
        for(int i=0;i<n;i++){
            coda.add(a.rimuovi());
        }
        System.out.println(coda);
        for(int i=n-1;i>=0;i--){
            b.aggiungi(coda.get(i));
        }
        
        return 1;
    }
    
}
