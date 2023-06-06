import java.util.Objects;

public class VettoreNullo implements Vettore {
    private int dim;
    
    public VettoreNullo(int dim) {
        this.dim = dim;
    }

    @Override
    public int dim() {
        return dim;
    }
    @Override
    public int val(int i) throws IllegalArgumentException {
        if(i<0 || i>dim()){
            throw new IllegalArgumentException("i non deve maggiore della dimensione o minore di 0");
        }
        return 0;
    }

    @Override
    public Vettore per(int alpha) {
       return this;
    }

    @Override
    public Vettore più(Vettore v) {
        Objects.requireNonNull(v,"il vettore non dev'essere nullo");

        return v;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<dim();i++){
            sb.append('0');
            if(!(i==dim()-1)){
                sb.append(',');
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
}
