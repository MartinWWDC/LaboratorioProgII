import java.util.ArrayList;
import java.util.List;

/**
 * Overview: un "extra" robot in grado di spostare un numero potenzialmente illimitato di
 * pacchi alla volta; 
 */
public class ExtraRobot implements Robot {
    
    private List<Pacco> coda=new ArrayList<Pacco>(); 
    public ExtraRobot() {}

    @Override
    public int sposta(Scaffalatura a, Scaffalatura b, int n) throws IllegalAccessException {
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
