import java.util.ArrayList;
import java.util.List;
/**
 * Questa classe permette di rappresentare un magazzino come un insieme di scaffalature
 */
public class Magazzino {
    /**
     * IR: non può essere null e non contiene elementi null 
     * AF: colonne rappresenta i vari scaffali del magazzino 
     */
    private List<Scaffalatura> colonne;

    public Magazzino() {
        colonne = new ArrayList<Scaffalatura>();
    }   
    /**
     * Permette di creare un magazzino con un determinato numero di scaffali;
     * @param size
     * @throws IllegalArgumentException quando size è minore di 0
     */
    public Magazzino(int size)throws IllegalArgumentException{
        super();
        if(size<=0){
            throw new IllegalArgumentException();   
        }
        for(int i=0;i<size;i++){
            colonne.add(new Scaffalatura());
        }
    };
    /**
     * ritorna la scaffalatura
     * @param i
     * @return la scaffalatura in posizione i
     */
    public Scaffalatura getScaffalatura(int i){
        if(i<0 && i>colonne.size()){
            throw new IllegalArgumentException("i out of range");
        }
        return colonne.get(i);
    }


    @Override
    public String toString() {
        String str="";
        for(int i=0;i<colonne.size();i++){
            str+=colonne.get(i)+"\n";
        }
        return str;
    }
    


    

    
}
