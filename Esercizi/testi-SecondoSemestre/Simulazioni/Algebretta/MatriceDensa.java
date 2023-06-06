import java.util.Objects;

public class MatriceDensa extends MatriceAbs{
    private int[][] matr;
    
    
    public MatriceDensa(int dim) {
        if(dim<=0){
            throw new IllegalArgumentException("dimensione non può essere nulla");
        }
        matr=new int[dim][dim];
    }

    public MatriceDensa(int[][] matr) {
        Objects.requireNonNull(matr, "La matrice non può essere null.");
        if (matr.length == 0) throw new IllegalArgumentException("La dimensione deve essere positiva.");
        final int dim = matr.length;
        this.matr = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
          if (matr[i].length != dim) throw new IllegalArgumentException("L'array deve essere quadrato.");
          for (int j = 0; j < dim; j++) this.matr[i][j] = matr[i][j];
        }
    }

    @Override
    public int dim() {
        return matr.length;
    }

    @Override
    public int val(int i, int j) throws IllegalArgumentException {
        if(!(i<dim() && j<dim())){
            throw new IllegalArgumentException("i e j devono essere minori della dimensione della matrice");
        }
        return matr[i][j];
    }

    @Override
    public Matrice per(int alpha) {
        if( alpha==0){
            return new MatriceNulla(dim());
        }
        final MatriceDensa N = new MatriceDensa(dim());
        for (int i = 0; i < dim(); i++) for (int j = 0; j < dim(); j++) N.matr[i][j] = alpha * matr[i][j];
        return N;

        
    }

    @Override
    public Matrice più(Matrice B) {
        Objects.requireNonNull(B, "La matrice non può essere null.");
        if (!checkMM(B)) throw new IllegalArgumentException("Le matrici non sono conformi.");
        if (B instanceof MatriceNulla) return this;
        final MatriceDensa C = new MatriceDensa(dim());
        for (int i = 0; i < dim(); i++)
        for (int j = 0; j < dim(); j++) C.matr[i][j] = matr[i][j] + B.val(i, j);
        return C;
    }

    @Override
    public Matrice per(Matrice B) {
          Objects.requireNonNull(B, "La matrice non può essere null.");
          if (!checkMM(B)) throw new IllegalArgumentException("Le matrici non sono conformi.");
          if (B instanceof MatriceNulla) return B;
          if (B instanceof MatriceIdentità) return this;
          final MatriceDensa C = new MatriceDensa(dim());
          for (int i = 0; i < dim(); i++)
            for (int j = 0; j < dim(); j++)
              for (int k = 0; k < dim(); k++) C.matr[i][j] += matr[i][k] * B.val(k, j);
          return C;
        
    }

}