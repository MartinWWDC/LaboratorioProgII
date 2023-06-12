import java.util.Objects;

/**
 * Overview: rappresenta un orario sul pianeta Betazed 
 */
public class BetaOrario {
    /**
     * IR: BetaOre è compreso tra  0 e 30 compresi
     * BetaMinuti è compreso tra 0 e 79 compresi 
     * AF:
     * BetaOre rappresenta le ore su Betazed 
     * BetaMinuti rappresenta i minuti su betazed  
     *
     */
    private final int BetaOre;
    private final int BetaMinuti;
    
    /**
     * Costruisce un betaOrario   
     * @param BetaOre
     * @param BetaMinuti
     * @throws IllegalArgumentException quando BetaOre è maggiore di 30 o minore di 0
     * @throws IllegalArgumentException quando BetaMinuti è maggiore di 79 o minore di 0
     */
    public BetaOrario(int BetaOre,int BetaMinuti) {
        if(BetaOre>30 || BetaOre < 0){
            throw new IllegalArgumentException("BetaOre non rispecchia le condizioni");
        }  
        if(BetaMinuti>79 || BetaMinuti < 0){
            throw new IllegalArgumentException("BetaMinuti non rispecchia le condizioni");
        }
        this.BetaOre=BetaOre;
        this.BetaMinuti=BetaMinuti;
    }
    /**
     * Aggiunge una durata in betaminuti e ne determina il betaorario di fine
     * 
     * @param n betaMinuti da aggiungere
     * @return il nuovo orario
     * @throws IllegalArgumentException quando BetaMinuti è maggiore di 79 o minore di 0
     * @throws IllegalAccessError l'ora di partenz e n devono essere tali per cui la fine della fascia cada nello stesso giorno in cui è iniziata altrimenti verrà lanciate eccezione 
     */
    public BetaOrario addDurata(int n)throws IllegalArgumentException,IllegalAccessError{
        if(n>79 || n < 0){
            throw new IllegalArgumentException("durata non rispecchia le condizioni dei betaminuti");
        }   
        if(n+BetaMinuti>79 && BetaOre>=29)  throw new IllegalAccessError("l'ora di partenz e n devono essere tali per cui la fine della fascia cada nello stesso giorno ");
         
        if (BetaMinuti + n <= 79) return new BetaOrario(BetaOre, BetaMinuti+n);
        int resto = BetaMinuti + n - 80;
        int minutiNew = 0;
        int oreNew = BetaMinuti+1;
        for (int i = 0; i<resto; i++) {
            minutiNew += 1;
            if (minutiNew>79) {
                minutiNew = 0;
                oreNew ++;
            }
            if (oreNew>30) {
                oreNew=0;
            }
        }
        return new BetaOrario(oreNew, minutiNew);
    }
    
    /**
     * Resituisce la differenza in betaminuti tra due betaorari 
     * @param orarioDif
     * @return
     */
    public boolean confronta(final BetaOrario b) {
            Objects.requireNonNull(b, "Non può essere null.");
            if(BetaOre>b.getBetaOre()) return false;
            if(BetaOre<b.getBetaOre()) return true;
            if(BetaMinuti>b.getBetaMinuti()) return false;
            if(BetaMinuti<b.getBetaMinuti()) return true;
            return false;
        }

    @Override
    public String toString() {
        return "BetaOrario [BetaOre=" + BetaOre + ", BetaMinuti=" + BetaMinuti + "]";
    }
    public int getBetaOre() {
        return BetaOre;
    }
    public int getBetaMinuti() {
        return BetaMinuti;
    }
    
    

    
}
