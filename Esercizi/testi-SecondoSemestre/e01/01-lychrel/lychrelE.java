public class lychrelE {

    // isPal
    // reversLong
    // seqLychrel

    /**
     * Questo metodo si occupera dato una String di verificare con un valore boolean se la stringa sia palindroma o meno
     * @param s stringa come input
     * @return valore di controllo sulla stringa sia o meno palindroma  
     */
    
    //requires: s non null
    //effects: ritorna true se la stringa s è palindroma, false altrimenti
    public static boolean isPal(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }       
        return true;
    }
    /**
     * Metodo che si occupa dato un long n in input naturale di restituirlo invertito 
     * @param n valore in input
     * @return valore n invertito  
     * @throws IllegalArgumentException lanciata se n è <0
     */
    
    //effects: restituisce un long che è ottenuto scrivendo le sue cifre dall'ultima alla prima
    //          lancia un illegalargument exception se il long è negativo
    public static long reversLong(long n) throws IllegalArgumentException {
        if (n<0){
            throw new IllegalArgumentException("n deve essere >= 0");
        }
        long nN;
        String strN=Long.toString(n);
        //System.out.println(strN);
        String nstrN="";
        for(int i=strN.length()-1;i>=0;i--){
            nstrN+=strN.charAt(i);
        }
        //System.out.println(nstrN);

        nN=Long.parseLong(nstrN);
        return nN;
    }
    /**
     * Metodo che dato un numero natuale n in input stampa a schermo tutte le sequenze di lychrel fino al raggiungimento di un numero palindromo
     * @param n
     */
  
    //modifies: sistem.out
    //effecte: stampa la sequenza di l... associata al numero in input, se il numero
    //          è negativo soleva un illegalargumentexception
    public static void seqLychrel(long n) {
        if (n<0){
            throw new IllegalArgumentException("n deve essere >= 0");
        }
        //System.out.println(n);

        for (; !isPal(Long.toString(n));n+=reversLong(n)) {
            System.out.println(n);


        }
        System.out.println(n);

        return;
    }
    
    public static void main(String[] args) {
        seqLychrel(59);
    }
   
}
