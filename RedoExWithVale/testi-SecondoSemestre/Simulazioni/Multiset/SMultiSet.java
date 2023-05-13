import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/**
 * overview: questa classe che implementa l'interfaccia StringMultiSet rappresenta 
 * un multiset di stringhe
 */
public class SMultiSet implements StringMultiSet {
    Boolean changed=false;
    /**
     * AF: ognì elemento non deve essere null 
     * 
     * RI: Implementa un MultiSet
     */

    //CAMPI
    HashMap<String,Integer> set;

    

    public SMultiSet(HashMap<String, Integer> set) throws IllegalArgumentException{
        if(set.get(null)!=null){
            throw new IllegalArgumentException("Non puoi avere elementi nulli");
        }

        this.set = new HashMap<String,Integer>(set);
    }
    

    public SMultiSet() {
        this.set = new HashMap<String,Integer>();
    }


    @Override
    public Iterator<String> iterator() {
        changed=false;
        return new Iterator<String>(){
        int index=0;
        int counter=0;
        Iterator<String> key=set.keySet().iterator();
        boolean check=false;
        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Unimplemented method 'next'");

        }

        @Override
        public String next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }

      };
    }

    @Override
    public int add(String s) throws IllegalArgumentException{
        if (s == null) throw new IllegalArgumentException("NO STRINGHE NULLEEEEE :( )");
        int m = multiplicity(s);
        set.put(s, multiplicity(s)+1);
        changed=true;
        return m;
    }
    private int add(String s,int i) throws IllegalArgumentException{
        if (s == null) throw new IllegalArgumentException("NO STRINGHE NULLEEEEE :( )");
        int m = multiplicity(s);
        set.put(s, multiplicity(s)+i);
        changed=true;

        return m;
    }

    @Override
    public int remove(String s) {
    int m = multiplicity(s);
        if(contains(s)){
            set.remove(s);
        }
        changed=true;

        return m;
    }

    @Override
    public boolean contains(String s) {
        return 	set.containsKey(s);
    }

    @Override
    public int multiplicity(String s) {
        if(contains(s)){
            return set.get(s);
        }else{
            return 0;
        }
    }

    @Override
    public int size() {
        return set.keySet().size();
    }

    @Override
    public StringMultiSet union(StringMultiSet o) {
        Objects.requireNonNull(o);

        SMultiSet so = (SMultiSet)o;
        SMultiSet nSet=new SMultiSet();
        set.forEach((key, value) -> {
            if (!so.contains(key) ||(value> nSet.multiplicity(key))){
                nSet.add(key, value);
            } else {
                if (multiplicity(key)<= nSet.multiplicity(key)){
                    nSet.add(key, nSet.multiplicity(key));
                }
            }
        });

        so.set.forEach((key, value) -> {
            if (!nSet.contains(key)){
                nSet.add(key, value);
            }
        });
        return nSet;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        Objects.requireNonNull(o);

        SMultiSet nSet=new SMultiSet();
        set.forEach((key, value) -> {
            if (o.contains(key)){
                if (multiplicity(key)<= nSet.multiplicity(key)){
                    nSet.add(key, multiplicity(key));
                };
            } else{
                nSet.add(key, nSet.multiplicity(key));
            }
        });
        return nSet;
    }
    
}
