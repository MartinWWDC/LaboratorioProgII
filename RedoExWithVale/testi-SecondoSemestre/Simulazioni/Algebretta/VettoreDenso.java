import java.util.Arrays;
import java.util.Objects;

/**
 * Overview: Classe che rappresenta un vettore denso. 

 */
public class VettoreDenso implements Vettore {
    private int[] vect;
      /**
         * AF: Vect rappresenta gli elementi del vettore
         * RI: Vect non deve essere nullo dimensione maggiore o uguale a 1
         */
    public VettoreDenso(int dim){
            if(!(dim>=1)){
                throw new IllegalArgumentException("deve contentere almeno un elemento");
            }
            vect = new int[dim];
        }    
    public VettoreDenso(int[] vect){
        Objects.requireNonNull(vect, "il vettore non può essere nullo");
        if(!(vect.length>=1)){
            throw new IllegalArgumentException("deve contentere almeno un elemento");
        }
        this.vect=vect.clone();
    }
    @Override
    public int dim() {
        return vect.length;
    }

    @Override
    public int val(int i){
        if(i<0 || i>dim()){
            throw new IllegalArgumentException("i non deve maggiore della dimensione o minore di 0");
        }
        return vect[i];
    }

    @Override
    public Vettore per(int alpha) {
        if(alpha==0){
            return new VettoreNullo(dim());
        }
        VettoreDenso v= new VettoreDenso(dim());
        for(int i=0;i<dim();i++){
            v.vect[i]=vect[i]*alpha;
        }
        return v;

    }

    @Override
    public Vettore più(Vettore v) {
        Objects.requireNonNull(v,"il vettore non dev'essere nullo");
        if (v instanceof VettoreNullo) return this;
        if(check(v)){
            throw new IllegalArgumentException("vettore non valido per la somma");
        }        
        final VettoreDenso res = new VettoreDenso(dim());
        for (int i = 0; i < vect.length; i++) res.vect[i] = vect[i] + v.val(i);
        return res;

    }
    @Override
    public String toString() {
        return Arrays.toString(vect);
    }
    
}
