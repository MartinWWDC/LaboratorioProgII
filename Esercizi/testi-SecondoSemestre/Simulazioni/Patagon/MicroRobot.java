/**
 * Permette di creare un robot che è in gradi traspostare solo 1 pacco per viaggio 
 */
public class MicroRobot implements Robot {
    
    public MicroRobot(){}    

    @Override
    public int sposta(Scaffalatura a, Scaffalatura b, int n) throws IllegalAccessException {
        if(a.getNPacchi()<=n){
            throw new IllegalArgumentException();
        }
        for(int i=0;i<n;i++){
            b.aggiungi(a.rimuovi());
        }
        return n;
    }
    
}
