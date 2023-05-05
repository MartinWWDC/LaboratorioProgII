public class PiastrellaQuadrata extends Piastrella{
    private final int lato;
    

    


    public PiastrellaQuadrata(int costo, int lato) {
        super(costo);
        if(lato <=0) throw new IllegalArgumentException("lato non può essere minore di 0");
        
        this.lato = lato;
    }





    @Override
    public int superfice() {
       return lato*lato;
    }

}