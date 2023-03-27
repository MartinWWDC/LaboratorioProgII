import java.util.ArrayList;

//Overview: Classe che rappresenta un insieme di interi
public class IntSet {
    //Campo
    ArrayList<Integer> set;
    /**
     * AF: ogni elemenento di set deve esere unico e un intero
     */
    /**
     * RI: gli elementi di set rappresentano gli elementi di un insieme
     */

    public IntSet() {
        set= new ArrayList<Integer>();
    }

    /*
    ----: 
    EFFECTS: aggiunge all'insieme l'intero n, se è già presente nell'insieme solleva un eccezione 
    illegal argument
    */
    /**
     * Si occupa di inserire elemento n all'iterno dell' insieme assicurandosi che non sia già presente 
     * @param n
     * @throws IllegalArgumentException
     */
    public void Insert(int n)throws IllegalArgumentException{
        if(contains(n)){
            throw new IllegalArgumentException("");
        }
        set.add(n);
    }

    /*
    effects: Si occupa di rimuovere un elemento n dall'insieme e lancia un eccezzione se
            l'elemento non è presente
    */
    /**
     * @param n
     * @throws IllegalArgumentException
     */
    public void remove(int n)throws IllegalArgumentException{
        if (!contains(n)){
            throw new IllegalArgumentException("Elemento non presente");
        }
        int s=set.indexOf(n);
        
        set.remove(s);

    }


    /**
     * Ritorna un valore boolean se n è contentuo o meno nell'insieme
     * @param n
     * @return
     */
    public boolean contains(int n) {
        return(set.contains(n));
    }

    /*
    
    Effects: ritorna la cardinalità dell'insieme
    */
    public int size(){
        return (set.size());
    }


    @Override
    public String toString() {
        String str="[";
        if(size()>0){
            for(int i=0;i<size()-1;i++){
                str+=set.get(i).toString()+",";
            }
            str+=set.get(size()-1).toString();
        }
        str+="]";
        return str;
    }

    public int choose() throws EmptyException{
        if (size() == 0){
            throw new EmptyException("insieme vuoto");
        }
        return(set.get(1));
    }


    
}
