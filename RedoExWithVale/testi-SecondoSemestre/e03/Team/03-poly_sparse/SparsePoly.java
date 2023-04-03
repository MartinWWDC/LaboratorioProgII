import java.util.ArrayList;
import java.util.List;

//Rappresentiamo un polinomio in maniera più efficente
public class SparsePoly{
    //Campi
    public record Term(int coeff,int degree) {
        public Term{
            if(degree<0) throw new NegativeExponentException("il grado deve essere maggiore di 0");
        }
    
        @Override
        public String toString() {
            return coeff+"^"+degree;
        }

    }
    /**
     * AF: Degree>0
     */
    /**
     * RI: ogni elemento di poly rappresenterà  n*x^c e poly sarà ordinato cresente
     */
    public List<Term> poly;
    public SparsePoly() {
        poly=new ArrayList<Term>();
    }
    public SparsePoly(int coeff,int degree) {
        this();

        if(coeff!=0)poly.add(new Term(coeff,degree));
    }
    
    /**
     * Resituisce il grado del polinomio
     * @return
     */
    public int degree(){
        return poly.size()>0? poly.get(poly.size()-1).degree:-1;
    }
    
    /**
     * Resituisce la posizione di un elemento in base al suo grado 
     * @param degree
     * @return
     */
    private int findByDegree(int degree) {
        int low = 0;
        int high = poly.size() - 1;
    
        while (low <= high) {
          int mid = (low + high) >>> 1;
          int midVal = poly.get(mid).degree;
    
          if (midVal < degree) low = mid + 1;
          else if (midVal > degree) high = mid - 1;
          else return mid;
        }
        return -(low + 1);
      }

    /**
     * Resituisce il coefficente di un elemento di grado degree
     * @param degree
     * @return
     */

    public int coeff(int degree) {
        int i=findByDegree(degree);
        if(i>=0) return poly.get(i).coeff;
        return 0;
    }
    
    public SparsePoly add(SparsePoly q) throws NullPointerException {
        SparsePoly result=new SparsePoly();
        int indexThis = 0, indexQ = 0;
        while(indexThis<poly.size() && indexQ<q.poly.size()){
            int diff = poly.get(indexThis).degree - q.poly.get(indexQ).degree;
            if (diff>0) result.poly.add(poly.get(indexThis++));
            else if( diff>0) result.poly.add(q.poly.get(indexQ++));
            else{
                int newCoeff=q.poly.get(indexQ).coeff+poly.get(indexThis).coeff;
                if (newCoeff != 0) result.poly.add(new Term(newCoeff, poly.get(indexThis).degree));
                indexThis++;
                indexQ++;
            }

        }
        while(indexThis<poly.size()) result.poly.add(poly.get(indexThis++));
        while(indexQ<q.poly.size()) result.poly.add(q.poly.get(indexThis++));
        return result;
    }


    public SparsePoly mul(SparsePoly other) throws NullPointerException {
        SparsePoly result=new SparsePoly();
       if(other.degree()==-1|| degree()==-1) return result;
       for (int indexThis = 0; indexThis < poly.size(); indexThis++)
       for (int indexOther = 0; indexOther < other.poly.size(); indexOther++) {
         int newCoeff = poly.get(indexThis).coeff * other.poly.get(indexOther).coeff;
         int newDegree = poly.get(indexThis).degree + other.poly.get(indexOther).degree;
 
         int index = result.findByDegree(newDegree);
         if (index >= 0) {
           newCoeff += result.poly.get(index).coeff;
           if (newCoeff == 0) result.poly.remove(index);
           else result.poly.set(index, new Term(newCoeff, newDegree));
         } else result.poly.add(-index - 1, new Term(newCoeff, newDegree));
       }
       return result;
    }

    
    @Override
    public String toString() {
        String toStr="";
        for(int i=0;i<poly.size();i++){
            toStr+="+"+poly.get(i).coeff+"x^"+poly.get(i).degree;
        }
        return toStr;

    }


   // public SparsePoly minus() {}

   // public SparsePoly sub(SparsePoly other) {}
    

}
