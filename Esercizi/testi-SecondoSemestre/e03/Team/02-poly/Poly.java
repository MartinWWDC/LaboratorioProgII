import java.util.ArrayList;
import java.util.List;

/*
overview: questa classe rappresenta pei polinomi a coefficienti interi in una
sola variabile

AF: 

IR: pol rappresenta un polinomio il cui ogni suo elemento in posizione i rappresenta pol[i]*x^(i)

*/



public class Poly {
    List<Integer> pol;

    public Poly() {
        pol=new ArrayList<>();
        pol.add(0);
    }
    
    public Poly(int c, int n) throws NegativeExponentException {
        if (n<0){
            throw new NegativeExponentException("esponente negativo");
        }
        pol=new ArrayList<>();
        for(int i=0;i<n;i++){
            pol.add(0);
        }
        pol.add(n, c);
    }
    /**
     * Restituisce il grado di un polinomio
     * @return
     */
    public int degree() {
        return pol.size();
        
    }
    //effetto: restituisce il coefficiente di grado g
    public int gEg(int g) {
        return (pol.get(g));
    }

    public Poly sub(Poly p){
        Poly nP=this;
        int oldD=nP.degree();
        if(p.degree()>nP.degree()){
            for (int i=nP.degree();i<p.degree();i++){
                nP.pol.add(-1*p.pol.get(i));
            }
        }
        for(int i=0;i<oldD;i++){
            nP.pol.set(i,nP.gEg(i)-p.gEg(i));
        }
        
        
        return nP;
        
    }

    @Override
    public String toString() {
        String str="";
        if(pol.size()>0){
            if(pol.size()==1){
                str+=pol.get(0);

            }else{
                for(int i=0;i<pol.size();i++){
                    if(pol.get(i)!=0){
                        if(i==0){
                            str+=pol.get(0);
                        }else{
                            if(pol.get(i)>=0){
                                str+="+";
                            }
                            str+=pol.get(i)+"x^"+i;
                        }
                    }
                }
            }
        }
        return str;
    }

    public Poly sum(Poly p) {
        
        if (p.degree()>this.degree()){
            Poly r = p;
            for(int i=0; i<this.degree(); i++){
                r.pol.set(i, p.gEg(i)+this.gEg(i));
            }
            return r;
        } else {
            Poly r = this;
            for(int i=0; i<p.degree(); i++){
                r.pol.set(i, p.gEg(i)+this.gEg(i));
            }
            return r;
        }

    }
 
}
